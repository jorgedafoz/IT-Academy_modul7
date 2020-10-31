package com.domain;

import java.util.ArrayList;
import java.util.List;

public class Video {
    protected String title;
    protected String url;
    protected List<String> tags = new ArrayList<String>();

    public Video(String title, String url, List<String> tags) {
        this.title = title;
        this.url = url;
        this.tags = tags;
    }

    public Video(String title, String url) {
        this.title = title;
        this.url = url;
    }

    @Override
    public String toString() {
        return "\nVideo: " +
                "\n{title='" + title + '\'' +
                "\n, url='" + url + '\'' +
                "\n, tags=" + tags +
                '}';
    }
}
