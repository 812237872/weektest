package com.example.a81223.bean;

public class New {
    private String TITLE;
    private String SUBTITLE;
    private String IMAGEURL;
    private String SHOWTIME;
    private String FROMNAME;

    public New(String TITLE, String SUBTITLE, String IMAGEURL, String SHOWTIME, String FROMNAME) {
        this.TITLE = TITLE;
        this.SUBTITLE = SUBTITLE;
        this.IMAGEURL = IMAGEURL;
        this.SHOWTIME = SHOWTIME;
        this.FROMNAME = FROMNAME;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getSUBTITLE() {
        return SUBTITLE;
    }

    public void setSUBTITLE(String SUBTITLE) {
        this.SUBTITLE = SUBTITLE;
    }

    public String getIMAGEURL() {
        return IMAGEURL;
    }

    public void setIMAGEURL(String IMAGEURL) {
        this.IMAGEURL = IMAGEURL;
    }

    public String getSHOWTIME() {
        return SHOWTIME;
    }

    public void setSHOWTIME(String SHOWTIME) {
        this.SHOWTIME = SHOWTIME;
    }

    public String getFROMNAME() {
        return FROMNAME;
    }

    public void setFROMNAME(String FROMNAME) {
        this.FROMNAME = FROMNAME;
    }

    @Override
    public String toString() {
        return "New{" +
                "TITLE='" + TITLE + '\'' +
                ", SUBTITLE='" + SUBTITLE + '\'' +
                ", IMAGEURL='" + IMAGEURL + '\'' +
                ", SHOWTIME='" + SHOWTIME + '\'' +
                ", FROMNAME='" + FROMNAME + '\'' +
                '}';
    }
}
