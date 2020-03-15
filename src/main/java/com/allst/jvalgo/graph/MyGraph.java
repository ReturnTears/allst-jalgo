package com.allst.jvalgo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
        // isVisit = new boolean[vertexList.size()];
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
        isVisit = new boolean[vertexList.size()];
        // 遍历所有节点进行dfs回溯
        for (int i = 0; i < getVertexSize(); i++) {
            if (!isVisit[i]) {
                dfs(isVisit, i);
            }
        }
    }

    /**
     * 对一个节点进行广度优先遍历
     * bf: breadth first 广度优先
     */
    public void bf(boolean[] isVisited, int i) {
        int v;  // 对立的头节点对应的下标
        int w;  // 邻接结点w
        // 队列，记录节点访问的顺序
        LinkedList queue = new LinkedList();
        // 访问节点，输出节点信息
        System.out.print(getValueByIndex(i) + " => ");
        // 标记为已访问
        isVisited[i] = true;
        // 将节点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()) {
            v = (int) queue.removeFirst();
            w = getFirstNeighbor(v);
            while (w != -1) { // 找到
                // 是否访问过
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + " => ");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                // 以v为前驱节点， 找w后面的下一个邻节点
                w = getNextNeighbor(v, w);  // 体现了广度优先
            }
        }
    }

    // 重写广度优先
    public void bfs() {
        isVisit = new boolean[vertexList.size()];
        for (int i = 0; i < getVertexSize(); i++) {
            if (!isVisit[i]) {
                bf(isVisit, i);
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
        // graph.dfs();

        System.out.println("广度遍历~~~");
        // graph.bfs();

        // 图的深度优先VS广度优先
        String[] values = {"1", "2", "3", "4", "5", "6", "7", "8"};
        MyGraph graph2 = new MyGraph(values.length);
        for (String v : values) {
            graph2.insertVertex(v);
        }
        graph2.insertEdge(0, 1, 1);
        graph2.insertEdge(0, 2, 1);
        graph2.insertEdge(1, 3, 1);
        graph2.insertEdge(1, 4, 1);
        graph2.insertEdge(3, 7, 1);
        graph2.insertEdge(4, 7, 1);
        graph2.insertEdge(2, 5, 1);
        graph2.insertEdge(2, 6, 1);
        graph2.insertEdge(5, 6, 1);
        System.out.println("深度遍历~~~");
        graph2.dfs();
        System.out.println();
        System.out.println("广度遍历~~~");
        graph2.bfs();
    }

}
