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
import com.example.physics.Answer.QuestionAnsweElectrodinamic;
import com.example.physics.R;


public class TestElectrodinamicFragment extends Fragment implements View.OnClickListener{

    TextView totalQuestionsTextView_electrodinamic;
    TextView questionTextView;
    Button ansA_electrodinamic , ansB_electrodinamic, ansC_electrodinamic;
    Button submitBtn_electrodinamic;

    int score=0;
    int totalQuestion_electrodinamic= QuestionAnsweElectrodinamic.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    public TestElectrodinamicFragment() {

    }



    public static TestElectrodinamicFragment newInstance() {
        return new TestElectrodinamicFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_test_electrodinamic, container, false);

        totalQuestionsTextView_electrodinamic = view.findViewById(R.id.total_questionelectrodinamic);
        questionTextView = view.findViewById(R.id.question);
        ansA_electrodinamic = view.findViewById(R.id.ans_A);
        ansB_electrodinamic = view.findViewById(R.id.ans_B);
        ansC_electrodinamic  = view.findViewById(R.id.ans_C);
        submitBtn_electrodinamic  = view.findViewById(R.id.submit_btn);

        ansA_electrodinamic.setOnClickListener(this);
        ansB_electrodinamic.setOnClickListener(this);
        ansC_electrodinamic.setOnClickListener(this);
        submitBtn_electrodinamic.setOnClickListener(this);
        totalQuestionsTextView_electrodinamic.setText("Заданий : "+totalQuestion_electrodinamic);

        loadNewQuestion();
        return view;

    }

    @Override
    public void onClick(View v) {
        ansA_electrodinamic.setBackgroundColor(Color.WHITE);
        ansB_electrodinamic.setBackgroundColor(Color.WHITE);
        ansC_electrodinamic.setBackgroundColor(Color.WHITE);
        Button clickedButton = (Button) v;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(QuestionAnsweElectrodinamic.correctAnswers[currentQuestionIndex])){
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
        if(score > totalQuestion_electrodinamic*0.60){
            passStatus = "Так держать!";
        }else{
            passStatus = "Попробуй еще";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(passStatus);
        builder.setMessage("Количество правильных "+ score+" из "+ totalQuestion_electrodinamic);
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

        if(currentQuestionIndex == totalQuestion_electrodinamic){
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionAnsweElectrodinamic.question[currentQuestionIndex]);
        ansA_electrodinamic.setText(QuestionAnsweElectrodinamic.choices[currentQuestionIndex][0]);
        ansB_electrodinamic.setText(QuestionAnsweElectrodinamic.choices[currentQuestionIndex][1]);
        ansC_electrodinamic.setText(QuestionAnsweElectrodinamic.choices[currentQuestionIndex][2]);

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

    }
