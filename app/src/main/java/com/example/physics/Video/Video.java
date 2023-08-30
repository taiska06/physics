package com.example.physics.Video;

import java.io.File;

public class Video {
    private File videoUrl;
    private String title;
    private String desc;


    public Video(File videoUrl, String title, String desc){
        this.videoUrl=videoUrl;
        this.title=title;
        this.desc=desc;
    }

    public String getVideoUrl() {
        return String.valueOf(videoUrl);
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}

