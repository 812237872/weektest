package com.example.bean;

public class New {
    private String title;
    private String source;
    private String source_url;

    public New(String title, String source, String source_url) {
        this.title = title;
        this.source = source;
        this.source_url = source_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    @Override
    public String toString() {
        return "New{" +
                "title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", source_url='" + source_url + '\'' +
                '}';
    }
}
