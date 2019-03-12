package com.example.bean;
/**
* bean 类
* @auther  ln
* created at 2019/2/18 10:30
*/



public class New {
    private String desc;
    private String url;
    private String type;
    private String publishedAt;

    public New(String desc, String url, String type, String publishedAt) {
        this.desc = desc;
        this.url = url;
        this.type = type;
        this.publishedAt = publishedAt;
    }

    public New() {
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "New{" +
                "desc='" + desc + '\'' +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                '}';
    }
}
