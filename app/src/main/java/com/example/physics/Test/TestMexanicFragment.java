package com.example.physics.Test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.physics.R;


public class TestMexanicFragment extends Fragment {



    public TestMexanicFragment() {
        // Required empty public constructor
    }



    public static TestMexanicFragment newInstance() {
        TestMexanicFragment fragment = new TestMexanicFragment();

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
        return inflater.inflate(R.layout.fragment_test_mexanic, container, false);
    }
}