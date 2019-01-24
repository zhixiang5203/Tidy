package com.szx.tidy.bean;

import java.util.List;

public class UserData {

    public static int SUCCESS = 20000;
    public static int FAIL = -1;

    private int error;
    private String results;
//    private List<ResultsBean> results;


    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }
}
