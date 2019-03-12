package com.example.bean;

import java.util.List;

public class NewsData {
    private List<New> data;

    public NewsData(List<New> data) {
        this.data = data;
    }

    public List<New> getData() {
        return data;
    }

    public void setData(List<New> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "NewsData{" +
                "data=" + data +
                '}';
    }
}
