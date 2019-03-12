package com.example.Bean;

public class New {
    private String news_title;
    private String news_summary;
    private String pic_url;

    public New(String news_title, String news_summary, String pic_url) {
        this.news_title = news_title;
        this.news_summary = news_summary;
        this.pic_url = pic_url;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_summary() {
        return news_summary;
    }

    public void setNews_summary(String news_summary) {
        this.news_summary = news_summary;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    @Override
    public String toString() {
        return "New{" +
                "news_title='" + news_title + '\'' +
                ", news_summary='" + news_summary + '\'' +
                ", pic_url='" + pic_url + '\'' +
                '}';
    }
}
