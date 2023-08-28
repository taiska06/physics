package com.example.physics.Video;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.physics.R;
import com.example.physics.Adapter.VideoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Video_OpticFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Video_OpticFragment extends Fragment  {


    public Video_OpticFragment() {
        // Required empty public constructor
    }



    public static Video_OpticFragment newInstance() {
        return new Video_OpticFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_video__optic, container, false);;
        List<Video> videoList = new ArrayList<>();
        ViewPager2 viewPager2 = view.findViewById(R.id.viewPager);

        videoList.add(new Video("android.resource://"+  view.getContext().getPackageName() + "/"+ R.raw.ic_v1,"Физика","книга"));
        videoList.add(new Video("android.resource://"+  view.getContext().getPackageName() + "/"+ R.raw.ic_v1,"Физика","книга"));
        VideoAdapter adapter = new VideoAdapter(videoList);
        viewPager2.setAdapter(adapter);
        return view;
    }
}