package com.example.physics.Test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.physics.R;


public class TestElectrodinamicFragment extends Fragment {



    public TestElectrodinamicFragment() {
        // Required empty public constructor
    }



    public static TestElectrodinamicFragment newInstance() {
        TestElectrodinamicFragment fragment = new TestElectrodinamicFragment();

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
        return inflater.inflate(R.layout.fragment_test_electrodinamic, container, false);
    }
}