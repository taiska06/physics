package com.example.physics.Test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.physics.Lesson.OpticFragment;
import com.example.physics.R;


public class TestOpticFragment extends Fragment {



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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_optic, container, false);
    }
}