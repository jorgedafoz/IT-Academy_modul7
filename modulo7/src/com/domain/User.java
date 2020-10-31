package com.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    protected String name;
    protected String surname;
    protected String password;
    protected Date registerDate;
    protected List<Video> videos = new ArrayList<Video>();

    public User(String name, String surname, String password, Date registerDate) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.registerDate = registerDate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public void addVideo(Video newVideo) {
        this.videos.add(newVideo);
    }

}

