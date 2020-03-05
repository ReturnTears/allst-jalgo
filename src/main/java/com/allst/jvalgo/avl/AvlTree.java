package com.allst.jvalgo.avl;

/**
 * 平衡二叉树
 *
 * @author YiYa
 * @since 2020-03-05 上午 12:40
 */
public class AvlTree {

    public static void main(String[] args) {

    }

}

class AVLTree {
    private Node node;

    public Node getNode() {
        return node;
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    // 左旋转
    private void leftRotate() {
        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        left = newNode;
    }
}