package com.allst.jvalgo.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树
 *
 * @author YiYa
 * @since 2020-02-28 上午 11:53
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        HufNode root = createHufTree(arr);
        preOrder(root);
    }

    //
    private static void preOrder(HufNode root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树~~~");
        }
    }

    /**
     * 创建霍夫曼树
     * @param arr   待创建为赫夫曼树的数组
     * @return      创建好赫夫曼树后的root节点
     */
    private static HufNode createHufTree(int[] arr) {
        List<HufNode> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new HufNode(value));
        }
        while (nodes.size() > 1) {
            // 排序
            Collections.sort(nodes);
            // System.out.println(nodes);

            //
            HufNode leftNode = nodes.get(0);
            HufNode rightNode = nodes.get(1);

            HufNode parent = new HufNode(leftNode.value + rightNode.value);
            parent.leftNode = leftNode;
            parent.rightNode = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);
        }

        return nodes.get(0);
    }

}

/**
 * 创建节点,并实现Comparable接口
 */
class HufNode implements Comparable<HufNode> {
    // 权值
    protected int value;
    // 左节点
    protected HufNode leftNode;
    // 右节点
    protected HufNode rightNode;

    // 构造
    public HufNode(int value) {
        this.value = value;
    }
    // toString

    @Override
    public String toString() {
        return "HufNode{" +
                "value=" + value +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        //
        if (this.leftNode != null) {
            this.leftNode.preOrder();
        }
        if (this.rightNode != null) {
            this.rightNode.preOrder();
        }
    }

    /**
     * 正序
     * @param o     节点
     * @return      值>0正序,<0倒序,=0相等
     */
    @Override
    public int compareTo(HufNode o) {
        return this.value - o.value;
    }
}

