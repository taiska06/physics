package com.example.physics.Lesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.physics.R;


public class ElectrodinamicFragment extends Fragment {



    public ElectrodinamicFragment() {
        // Required empty public constructor
    }


    public static ElectrodinamicFragment newInstance() {
        ElectrodinamicFragment fragment = new ElectrodinamicFragment();

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
        return inflater.inflate(R.layout.fragment_electrodinamic, container, false);
    }
}
