package com.example.bean;

public class New {
    private String title;
    private String date;
    private String thumbnail_pic_s;
    private String thumbnail_pic_s02;

    public New(String title, String date, String thumbnail_pic_s, String thumbnail_pic_s02) {
        this.title = title;
        this.date = date;
        this.thumbnail_pic_s = thumbnail_pic_s;
        this.thumbnail_pic_s02 = thumbnail_pic_s02;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public String getThumbnail_pic_s02() {
        return thumbnail_pic_s02;
    }

    public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
        this.thumbnail_pic_s02 = thumbnail_pic_s02;
    }

    @Override
    public String toString() {
        return "New{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", thumbnail_pic_s='" + thumbnail_pic_s + '\'' +
                ", thumbnail_pic_s02='" + thumbnail_pic_s02 + '\'' +
                '}';
    }
}
