package com.allst.jvalgo.tree;

/**
 * 二叉树
 * 前序
 * 中序
 * 后序
 * @author YiYa
 * @since 2020-02-23 上午 12:23
 */
public class BinTree {

    public static void main(String[] args) {
        // 创建一个二叉树
        BinaryTree tree = new BinaryTree();
        HerosNode root = new HerosNode(1, "吸血鬼");
        HerosNode node2 = new HerosNode(2, "火男");
        HerosNode node3 = new HerosNode(3, "妖姬");
        HerosNode node4 = new HerosNode(4, "凤凰");
        HerosNode node5 = new HerosNode(5, "狐狸");

        // 二叉树应该是递归创建的

        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
        tree.setRoot(root);

        System.out.println("前序遍历: ");
        tree.preOrder();

        System.out.println("中序遍历: ");
        tree.midOrder();

        System.out.println("后序遍历: ");
        tree.postOrder();
    }

}

/**
 * 定义二叉树
 */
class BinaryTree {

    private HerosNode root;

    public void setRoot(HerosNode root) {
        this.root = root;
    }

    // 前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，不能遍历~~~");
        }
    }

    // 中序遍历
    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        } else {
            System.out.println("二叉树为空，不能遍历~~~");
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，不能遍历~~~");
        }
    }
}

/**
 * 创建Node节点
 */
class HerosNode {
    private int no;
    private String name;
    private HerosNode left;
    private HerosNode right;

    public HerosNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HerosNode getLeft() {
        return left;
    }

    public void setLeft(HerosNode left) {
        this.left = left;
    }

    public HerosNode getRight() {
        return right;
    }

    public void setRight(HerosNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HerosNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    // 前序遍历
    public void preOrder() {
        // 先输出父节点
        System.out.println(this);
        // 递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        // 递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void midOrder() {
        // 递归向左子树前序遍历
        if (this.left != null) {
            this.left.midOrder();
        }
        // 输出父节点
        System.out.println(this);
        // 递归向右子树前序遍历
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    // 后序遍历
    public void postOrder() {
        // 递归向左子树前序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        // 递归向右子树前序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        // 输出父节点
        System.out.println(this);
    }
}