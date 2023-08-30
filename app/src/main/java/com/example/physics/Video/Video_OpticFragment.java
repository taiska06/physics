package com.example.physics.Video;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.physics.R;
import com.example.physics.Adapter.VideoAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Video_OpticFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Video_OpticFragment extends Fragment  {
    private View view;

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
        view=inflater.inflate(R.layout.fragment_video__optic, container, false);;
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        StorageReference videoRef = storageRef.child("ic_v1.mp4");
        File localFile = null;
        try {
            localFile = File.createTempFile("ic_v1", "mp4");
        } catch (IOException e) {
            e.printStackTrace();
        }
        File finalLocalFile = localFile;
        videoRef.getFile(localFile)
                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        List<Video> videoList = new ArrayList<>();
                        ViewPager2 viewPager2 = view.findViewById(R.id.viewPager);

                        videoList.add(new Video(new File(finalLocalFile.getAbsolutePath()), "Физика", "книга"));
                        videoList.add(new Video(new File(finalLocalFile.getAbsolutePath()), "Физика задачник", "книга"));
                        videoList.add(new Video(new File(finalLocalFile.getAbsolutePath()), "Физика физика", "книга"));
                        videoList.add(new Video(new File(finalLocalFile.getAbsolutePath()), "Физика", "книга"));
                        videoList.add(new Video(new File(finalLocalFile.getAbsolutePath()), "Физика", "книга"));
                        VideoAdapter adapter = new VideoAdapter(videoList);
                        viewPager2.setAdapter(adapter);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Обработка ошибки
                    }
                });
        return view;
    }
}