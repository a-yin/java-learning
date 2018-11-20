package com.lingb.mystudy.java;

/**
 * Created by lingb on 2018-10-15
 */
public class WordTable {

    private String from;
    private String to;

    public WordTable() {
    }

    public WordTable(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "WordTable{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
