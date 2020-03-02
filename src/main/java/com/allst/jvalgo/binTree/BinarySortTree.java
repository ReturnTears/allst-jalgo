package com.allst.jvalgo.binTree;

/**
 * 二叉排序树
 *
 * @author YiYa
 * @since 2020-03-02 下午 09:24
 */
public class BinarySortTree {

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinSortTree tree = new BinSortTree();
        // 循环添加节点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }
        // 中序遍历二叉排序树
        tree.infixOrder();
    }

}

/**
 * 创建二叉排序树
 */
class BinSortTree {
    private Node root;

    /**
     * 添加节点方法
     * @param node  节点
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空, 不能遍历~~~");
        }
    }
}

/**
 * Node节点
 */
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

    /**
     * 递归添加节点， 注意需要满足二叉排序树的要求
     *
     * @param node 节点
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        // 比较添加节点的值与根节点的关系
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                // 递归向左子树添加
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                // 递归向右子树添加
                this.right.add(node);
            }
        }

    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}