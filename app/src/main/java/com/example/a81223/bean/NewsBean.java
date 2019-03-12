package com.example.a81223.bean;

import java.util.List;

public class NewsBean {
    private List<New> data;

    public NewsBean(List<New> data) {
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
        return "NewsBean{" +
                "data=" + data +
                '}';
    }
}
