package com.lingb.mystudy.dsaa.day10;

import com.lingb.mystudy.dsaa.day03.MyQueue;

import java.util.Stack;

/**
 * 图，类似于树，由顶点+边 组成
 *
 * Created by lingb on 2018-11-18
 */
public class Graph {

    /**
     * 顶点最大值
     */
    private final int MAXSIZE = 20 ;

    /**
     * 顶点数组（点）
     */
    private Vertex[] vertexes;

    /**
     * 当前顶点个数
     */
    private int nVertex;

    /**
     * 邻接矩阵（边）
     */
    private int adjMat[][];

    /**
     * DFS 栈
     */
    private Stack<Integer> stack;

    /**
     * BFS 队列
     */
    private MyQueue queue;

    public Graph() {
        vertexes = new Vertex[MAXSIZE];
        adjMat = new int[MAXSIZE][MAXSIZE];
        for (int i = 0; i < MAXSIZE; i++) {
            for(int j = 0; j< MAXSIZE; j++) {
                adjMat[i][j] = 0;
            }
        }

        nVertex = 0;
        stack = new Stack<>();
        queue = new MyQueue();
    }

    /**
     * 添加顶点
     *
     * @param label
     */
    public void addVertex(char label) {
        vertexes[nVertex++] = new Vertex(label);
    }

    /**
     * 添加边
     * @param start
     * @param end
     */
    public void addEdge(int start, int end) {
        // 邻接矩阵
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }


    /**
     * 获取未被访问过的顶点
     *
     * @param v
     * @return int
     */
    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVertex; i++) {
            // 邻接的未被访问过的顶点
            if (adjMat[v][i] == 1 && !vertexes[i].isVisited()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * DFS 深度优先遍历
     */
    public void dfs(){
        // 首先访问0号顶点
        vertexes[0].setVisited(true);
        // 显示顶点
        printVertex(0);
        // 压入栈
        stack.push(0);
        while (!stack.empty()) {
            // 获取一个未被访问过的邻接点
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                // 弹出一个顶点
                stack.pop();

            } else {
                vertexes[v].setVisited(true);
                printVertex(v);
                stack.push(v);
            }
        }

        // 复位
        for(int i = 0; i < nVertex; i++) {
            vertexes[i].setVisited(false);
        }
    }

    /**
     * BFS 广度优先搜索
     */
    public void bfs() {
        // 首先访问0号顶点
        vertexes[0].setVisited(true);
        // 显示顶点
        printVertex(0);
        // 加入队列
        queue.insert(0);
        while (!queue.isEmpty()) {
            int v = getAdjUnvisitedVertex(queue.peek());
            if ( v == -1) {
                queue.remove();

            } else {
                vertexes[v].setVisited(true);
                printVertex(v);
                queue.insert(v);
            }
        }

        // 复位
        for (int j = 0; j < nVertex; j++) {
            vertexes[j].setVisited(false);
        }
    }


    /**
     * 最小生成树
     */
    public void mst() {

    }

    /**
     * 打印顶点
     */
    public void printVertex(int v) {
        System.out.print(vertexes[v].getLabel());
    }


}
