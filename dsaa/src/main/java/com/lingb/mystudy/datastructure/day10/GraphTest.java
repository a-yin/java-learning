package com.lingb.mystudy.datastructure.day10;

import org.junit.Test;

/**
 * Created by lingb on 2018-11-18
 */
public class GraphTest {

    @Test
    public void test() {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);

        graph.dfs();
        graph.bfs();

    }
}
