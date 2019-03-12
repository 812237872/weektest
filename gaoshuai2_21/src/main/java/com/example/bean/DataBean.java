package com.example.bean;

public class DataBean {
    private Data data;

    public DataBean(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "data=" + data +
                '}';
    }
}
