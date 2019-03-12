package com.example.bean;

import java.util.List;

public class Data {
    private List<New> list;

    public Data(List<New> list) {
        this.list = list;
    }

    public List<New> getList() {
        return list;
    }

    public void setList(List<New> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Data{" +
                "list=" + list +
                '}';
    }
}
