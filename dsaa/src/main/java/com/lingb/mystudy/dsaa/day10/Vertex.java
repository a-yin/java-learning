package com.lingb.mystudy.dsaa.day10;

/**
 * 图的顶点
 *
 * Created by lingb on 2018-11-18
 */
public class Vertex {

    private char label;
    private boolean visited;

    public Vertex(char label) {
        this.label = label;
        visited = false;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
