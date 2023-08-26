package com.example.physics.Fragment;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.physics.Activity.MainActivity;
import com.example.physics.Lesson.ElectrodinamicFragment;
import com.example.physics.Lesson.MexanicFragment;
import com.example.physics.Lesson.OpticFragment;
import com.example.physics.Lesson.TermodinamicFragment;
import com.example.physics.R;
import com.example.physics.Test.TestElectrodinamicFragment;
import com.example.physics.Test.TestMexanicFragment;
import com.example.physics.Test.TestOpticFragment;
import com.example.physics.Test.TestTermodinamicFragment;


public class LessonFragment extends Fragment {


    public LessonFragment() {
        // Required empty public constructor
    }


    public static LessonFragment newInstance() {
        return new LessonFragment();
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
        Button btn3 = view.findViewById(R.id.btn3);
        Button btn4 = view.findViewById(R.id.btn4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 showOptic();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMexanic();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showElectrodinamic();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTermodinamic();
            }
        });
}


    private void showOptic(){
        ConstraintLayout contlay = requireView().findViewById(R.id.contlayoptic);
        View view= LayoutInflater.from(getContext()).inflate(R.layout.dialog_optic,contlay);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button tema_optic = view.findViewById(R.id.temaoptic);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button test_optic = view.findViewById(R.id.test_optic);
        AlertDialog.Builder builder= new AlertDialog.Builder(requireContext());
        builder.setView(view);
        final AlertDialog alertDialog =builder.create();
        tema_optic.findViewById(R.id.temaoptic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOpticFragment();
                alertDialog.dismiss();
            }
        });
        test_optic.findViewById(R.id.test_optic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTestOpticFragment();
                alertDialog.dismiss();
            }
        });
        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    private void showMexanic(){
        ConstraintLayout contlay = requireView().findViewById(R.id.contlaymexanic);
        View view= LayoutInflater.from(getContext()).inflate(R.layout.dialog_mexanic,contlay);
        Button tema_mexanic = view.findViewById(R.id.tema_mexanic);
        Button test_mexanic=view.findViewById(R.id.test_mexanic);
        AlertDialog.Builder builder= new AlertDialog.Builder(requireContext());
        builder.setView(view);
        final AlertDialog alertDialog =builder.create();
        tema_mexanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMexanicFragment();
                alertDialog.dismiss();
            }
        });
        test_mexanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTestMexanicFragment();
                alertDialog.dismiss();
            }
        });
        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    private void showElectrodinamic(){
        ConstraintLayout contlay = requireView().findViewById(R.id.contlayelectrodinamic);
        View view= LayoutInflater.from(getContext()).inflate(R.layout.dialog_electrodinamic,contlay);

        Button tema_electrodinamic = view.findViewById(R.id.tema_electrodinamic);
        Button test_electrodinamic = view.findViewById(R.id.test_electrodinamic);

        AlertDialog.Builder builder= new AlertDialog.Builder(requireContext());
        builder.setView(view);
        final AlertDialog alertDialog =builder.create();
        tema_electrodinamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openElectrodinamicFragment();
                alertDialog.dismiss();
            }
        });
        test_electrodinamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTestElectrodinamicFragment();
                alertDialog.dismiss();
            }
        });
        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }
    private void showTermodinamic(){
        ConstraintLayout contlay = requireView().findViewById(R.id.contlaytermodinamic);
        View view= LayoutInflater.from(getContext()).inflate(R.layout.dialog_termodinamic,contlay);
        Button tema_termodinamic = view.findViewById(R.id.tema_termodinamic);
        Button test_termodinamic = view.findViewById(R.id.test_termodinamic);

        AlertDialog.Builder builder= new AlertDialog.Builder(requireContext());
        builder.setView(view);
        final AlertDialog alertDialog =builder.create();
        tema_termodinamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTermodinamicFragment();
                alertDialog.dismiss();
            }
        });
        test_termodinamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTestTermodinamicFragment();
                alertDialog.dismiss();
            }
        });
        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
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
    private void openTermodinamicFragment(){
        TermodinamicFragment termodinamicFragment=TermodinamicFragment.newInstance();
        ((MainActivity)requireActivity()).pushFragmentToStack(MainActivity.BACK_STACK_LESSON,termodinamicFragment);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerLesson,termodinamicFragment).commit();
    }
    private void openElectrodinamicFragment(){
        ElectrodinamicFragment electrodinamicFragment= ElectrodinamicFragment.newInstance();
        ((MainActivity)requireActivity()).pushFragmentToStack(MainActivity.BACK_STACK_LESSON,electrodinamicFragment);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerLesson,electrodinamicFragment).commit();
    }
    private void openTestOpticFragment(){
        TestOpticFragment testOpticFragment= TestOpticFragment.newInstance();

        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerLesson, testOpticFragment).commit();
    }
    private void openTestMexanicFragment(){
        TestMexanicFragment testMexanicFragment = TestMexanicFragment.newInstance();
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerLesson, testMexanicFragment).commit();
    }
    private void openTestElectrodinamicFragment(){
       TestElectrodinamicFragment testElectrodinamicFragment = TestElectrodinamicFragment.newInstance();

        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerLesson, testElectrodinamicFragment).commit();
    }
    private void openTestTermodinamicFragment(){
        TestTermodinamicFragment testTermodinamicFragment=TestTermodinamicFragment.newInstance();

        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerLesson, testTermodinamicFragment).commit();
    }
}