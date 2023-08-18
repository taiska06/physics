package com.example.physics.Test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.physics.Activity.LoginActivity;
import com.example.physics.Fragment.LessonFragment;
import com.example.physics.Lesson.OpticFragment;
import com.example.physics.QuestionAnswerOptic;
import com.example.physics.R;


public class TestOpticFragment extends Fragment  implements View.OnClickListener {
    TextView totalQuestionsTextView_optic;
    TextView questionTextView;
    Button ansA_optic, ansB_optic, ansC_optic;
    Button submitBtn_optic;

    int score=0;
    int totalQuestion_optic = QuestionAnswerOptic.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";


    public TestOpticFragment() {
        // Required empty public constructor
    }



    public static TestOpticFragment newInstance() {
        TestOpticFragment fragment = new TestOpticFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onClick(View view) {

        ansA_optic.setBackgroundColor(Color.WHITE);
        ansB_optic.setBackgroundColor(Color.WHITE);
        ansC_optic.setBackgroundColor(Color.WHITE);
        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(QuestionAnswerOptic.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();

        }else{
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.rgb(0,204,153));

        }

    }



    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion_optic*0.60){
            passStatus = "Молодец";
        }else{
            passStatus = "Ты пытался";
        }

        new AlertDialog.Builder(getContext())
                .setTitle(passStatus)
                .setMessage("Количество правильных "+ score+" из "+ totalQuestion_optic)
                .setPositiveButton("Перезапустить",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();


    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion_optic ){
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionAnswerOptic.question[currentQuestionIndex]);
        ansA_optic.setText(QuestionAnswerOptic.choices[currentQuestionIndex][0]);
        ansB_optic.setText(QuestionAnswerOptic.choices[currentQuestionIndex][1]);
        ansC_optic.setText(QuestionAnswerOptic.choices[currentQuestionIndex][2]);

    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.fragment_test_optic, container, false);

        totalQuestionsTextView_optic = view.findViewById(R.id.total_questionoptic);
        questionTextView = view.findViewById(R.id.question);
        ansA_optic = view.findViewById(R.id.ans_A);
        ansB_optic = view.findViewById(R.id.ans_B);
        ansC_optic = view.findViewById(R.id.ans_C);
        submitBtn_optic = view.findViewById(R.id.submit_btn);

        ansA_optic.setOnClickListener(this);
        ansB_optic.setOnClickListener(this);
        ansC_optic.setOnClickListener(this);
        submitBtn_optic.setOnClickListener(this);

        totalQuestionsTextView_optic.setText("Заданий : "+totalQuestion_optic);

        loadNewQuestion();

        return view;
    }
}




