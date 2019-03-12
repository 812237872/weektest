package com.example.bean;

import java.util.List;
/**
* bean类
* @auther  ln
* created at 2019/2/18 10:30
*/



public class NewsData {
    private List<New> results;

    public NewsData(List<New> results) {
        this.results = results;
    }

    public NewsData() {
    }

    public List<New> getResults() {
        return results;
    }

    public void setResults(List<New> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "NewsData{" +
                "results=" + results +
                '}';
    }
}
