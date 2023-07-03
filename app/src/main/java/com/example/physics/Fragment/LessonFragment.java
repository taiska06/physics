package com.example.physics.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.physics.Activity.MainActivity;
import com.example.physics.R;


public class LessonFragment extends Fragment {



    public LessonFragment() {
        // Required empty public constructor
    }


    public static LessonFragment newInstance() {
        LessonFragment fragment = new LessonFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lesson, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeUiComponent(view);
    }

    private void initializeUiComponent(View view) {
        Button btn = view.findViewById(R.id.btn);
        Button btn2 = view.findViewById(R.id.btn2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOpticFragment();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMexanicFragment();
            }
        });
    }

    private void openOpticFragment(){
        OpticFragment opticFragment = OpticFragment.newInstance();
        ((MainActivity)requireActivity()).pushFragmentToStack(MainActivity.BACK_STACK_LESSON,opticFragment);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerLesson,opticFragment).commit();
    }

    private void openMexanicFragment(){
        MexanicFragment mexanicFragment=MexanicFragment.newInstance();
        ((MainActivity)requireActivity()).pushFragmentToStack(MainActivity.BACK_STACK_LESSON,mexanicFragment);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerLesson,mexanicFragment).commit();
    }
}