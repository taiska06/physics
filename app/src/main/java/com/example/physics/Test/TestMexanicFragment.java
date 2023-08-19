package com.example.physics.Test;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.physics.Activity.MainActivity;
import com.example.physics.Answer.QuestionAnswerMexanic;
import com.example.physics.R;


public class TestMexanicFragment extends Fragment implements View.OnClickListener {
    TextView totalQuestionsTextView_mexanic;
    TextView questionTextView;
    Button ansA_mexanic , ansB_mexanic, ansC_mexanic ;
    Button submitBtn_mexanic;

    int score=0;
    int totalQuestion_mexanic = QuestionAnswerMexanic.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";



    public TestMexanicFragment() {
        // Required empty public constructor
    }



    public static TestMexanicFragment newInstance() {
        return new TestMexanicFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onClick(View v) {
        ansA_mexanic.setBackgroundColor(Color.WHITE);
        ansB_mexanic.setBackgroundColor(Color.WHITE);
        ansC_mexanic.setBackgroundColor(Color.WHITE);
        Button clickedButton = (Button) v;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(QuestionAnswerMexanic.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();

        }else{
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.rgb(234,137,154));
        }
    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion_mexanic*0.60){
            passStatus = "Так держать!";
        }else{
            passStatus = "Попробуй еще";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(passStatus);
        builder.setMessage("Количество правильных "+ score+" из "+ totalQuestion_mexanic);
        builder.setPositiveButton("Выйти", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                exit();
            }
        });
        builder.setNegativeButton("Перезапустить", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                restartQuiz();
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion_mexanic ){
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionAnswerMexanic.question[currentQuestionIndex]);
        ansA_mexanic.setText(QuestionAnswerMexanic.choices[currentQuestionIndex][0]);
        ansB_mexanic.setText(QuestionAnswerMexanic.choices[currentQuestionIndex][1]);
        ansC_mexanic.setText(QuestionAnswerMexanic.choices[currentQuestionIndex][2]);

    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }

    void exit(){
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_test_mexanic, container, false);

        totalQuestionsTextView_mexanic = view.findViewById(R.id.total_questionmexanic);
        questionTextView = view.findViewById(R.id.question);
        ansA_mexanic = view.findViewById(R.id.ans_A);
        ansB_mexanic = view.findViewById(R.id.ans_B);
        ansC_mexanic  = view.findViewById(R.id.ans_C);
        submitBtn_mexanic  = view.findViewById(R.id.submit_btn);

        ansA_mexanic.setOnClickListener(this);
        ansB_mexanic.setOnClickListener(this);
        ansC_mexanic.setOnClickListener(this);
        submitBtn_mexanic .setOnClickListener(this);
        totalQuestionsTextView_mexanic.setText("Заданий : "+totalQuestion_mexanic);
        loadNewQuestion();
        return view;
    }
}