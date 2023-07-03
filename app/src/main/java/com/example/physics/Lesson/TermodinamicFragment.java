package com.example.physics.Lesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.physics.R;


public class TermodinamicFragment extends Fragment {



    public TermodinamicFragment() {
        // Required empty public constructor
    }


    public static TermodinamicFragment newInstance() {
        TermodinamicFragment fragment = new TermodinamicFragment();

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
        return inflater.inflate(R.layout.fragment_termodinamic, container, false);
    }
}
