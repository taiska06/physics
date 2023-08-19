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
import com.example.physics.Answer.QuestionAnswerTermodinamic;
import com.example.physics.R;


public class TestTermodinamicFragment extends Fragment implements View.OnClickListener {
    TextView totalQuestionsTextView_termodinamic;
    TextView questionTextView;
    Button ansA_termodinamic , ansB_termodinamic, ansC_termodinamic;
    Button submitBtn_termodinamic;

    int score=0;
    int totalQuestion_termodinamic= QuestionAnswerTermodinamic.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";



    public TestTermodinamicFragment() {
        // Required empty public constructor
    }



    public static TestTermodinamicFragment newInstance() {
        return new TestTermodinamicFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        ansA_termodinamic.setBackgroundColor(Color.WHITE);
        ansB_termodinamic.setBackgroundColor(Color.WHITE);
        ansC_termodinamic.setBackgroundColor(Color.WHITE);
        Button clickedButton = (Button) v;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(QuestionAnswerTermodinamic.correctAnswers[currentQuestionIndex])){
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
        if(score > totalQuestion_termodinamic*0.60){
            passStatus = "Так держать!";
        }else{
            passStatus = "Попробуй еще";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(passStatus);
        builder.setMessage("Количество правильных "+ score+" из "+ totalQuestion_termodinamic);
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

        if(currentQuestionIndex == totalQuestion_termodinamic){
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionAnswerTermodinamic.question[currentQuestionIndex]);
        ansA_termodinamic.setText(QuestionAnswerTermodinamic.choices[currentQuestionIndex][0]);
        ansB_termodinamic.setText(QuestionAnswerTermodinamic.choices[currentQuestionIndex][1]);
        ansC_termodinamic.setText(QuestionAnswerTermodinamic.choices[currentQuestionIndex][2]);

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
        View view =  inflater.inflate(R.layout.fragment_test_termodinamic, container, false);

        totalQuestionsTextView_termodinamic = view.findViewById(R.id.total_questiontermodinamic);
        questionTextView = view.findViewById(R.id.question);
        ansA_termodinamic = view.findViewById(R.id.ans_A);
        ansB_termodinamic = view.findViewById(R.id.ans_B);
        ansC_termodinamic  = view.findViewById(R.id.ans_C);
        submitBtn_termodinamic  = view.findViewById(R.id.submit_btn);

        ansA_termodinamic.setOnClickListener(this);
        ansB_termodinamic.setOnClickListener(this);
        ansC_termodinamic.setOnClickListener(this);
        submitBtn_termodinamic.setOnClickListener(this);
        totalQuestionsTextView_termodinamic.setText("Заданий : "+totalQuestion_termodinamic);

        loadNewQuestion();
        return view;
    }
}