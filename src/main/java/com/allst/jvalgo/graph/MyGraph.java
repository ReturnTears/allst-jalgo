package com.allst.jvalgo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 图
 *
 * @author YiYa
 * @since 2020-03-08 下午 11:33
 */
public class MyGraph {
    //顶点集合
    private List<String> vertexList;
    // 存储图对应的邻接矩阵
    private int[][] edges;
    // 边的数目
    private int numOfEdges;

    private boolean[] isVisit;

    public MyGraph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisit = new boolean[5];
    }

    // 深度优先遍历算法
    public void dfs(boolean[] isVisit ,int index) {
        System.out.print(getValueByIndex(index) + " -> ");

        isVisit[index] = true;

        int w = getFirstNeighbor(index);

        while (w != -1) {
            if (!isVisit[w]) {
                dfs(isVisit, w);
            }
            w = getNextNeighbor(index, w);
        }
    }

    // 对dfs方法进行重载
    public void dfs() {
        // 遍历所有节点进行dfs回溯
        for (int i = 0; i < getVertexSize(); i++) {
            if (!isVisit[i]) {
                dfs(isVisit, i);
            }
        }
    }



    /**
     * 获取第一个邻接节点
     * @param index 索引
     * @return 如果存在就返回对应的下标， 否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 通过邻接节点的下标来获取下一个邻接结点
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 插入节点
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 边的数目
     */
    public int getVertexSize() {
        return vertexList.size();
    }

    /**
     * 获取顶点i对应的数据
     * @param i
     * @return
     */
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * 获取权值
     * @param v1
     * @param v2
     * @return
     */
    private int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 显示图
     */
    public void showGraph() {
        for (int[] line : edges) {
            System.out.println(Arrays.toString(line));
        }
    }

    /**
     * 添加边
     * @param v1
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }



    public static void main(String[] args) {
        int n = 5;
        String[] vertexValue = {"A", "B", "C", "D", "E"};
        MyGraph graph = new MyGraph(n);
        for (String ver : vertexValue) {
            graph.insertVertex(ver);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.showGraph();

        System.out.println("深度遍历~~~");
        graph.dfs();
    }

}
