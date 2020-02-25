package com.allst.jvalgo.tree;

/**
 * 二叉树-顺序存储二叉树
 * @author YiYa
 * @since 2020-02-26 上午 12:23
 */
public class ArrayBinaryTree {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        // 创建
        ArrBinTree binTree = new ArrBinTree(arr);
        System.out.println("前序遍历~~~");
        binTree.preOrder();
        System.out.println("中序遍历~~~");
        binTree.midOrder();
        System.out.println("后序遍历~~~");
        binTree.postOrder();
    }

}

/**
 * 编写一个ArrayBinaryTree,实现顺序存储二叉树遍历
 */
class ArrBinTree {
    // 存储数据节点的数组
    private int[] arr;

    public ArrBinTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 顺序存储二叉树的前序遍历
     * @param index     数组下标
     */
    public void preOrder(int index) {
        // 如果数组为空
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空, 不能按照二叉树的前序遍历~~~");
        }
        // 输出当前元素
        System.out.println(arr[index]);
        // 向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        // 向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    // 重载方法preOrder
    public void preOrder() {
        this.preOrder(0);
    }

    /**
     * 顺序存储二叉树的中序遍历
     * @param index     数组下标
     */
    public void midOrder(int index) {
        // 如果数组为空
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空, 不能按照二叉树的中序遍历~~~");
        }
        // 向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            midOrder(index * 2 + 1);
        }
        // 输出当前元素
        System.out.println(arr[index]);
        // 向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            midOrder(index * 2 + 2);
        }
    }

    public void midOrder() {
        this.midOrder(0);
    }

    /**
     * 顺序存储二叉树的后序遍历
     * @param index     数组下标
     */
    public void postOrder(int index) {
        // 如果数组为空
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空, 不能按照二叉树的后序遍历~~~");
        }
        // 向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            postOrder(index * 2 + 1);
        }
        // 向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            postOrder(index * 2 + 2);
        }
        // 输出当前元素
        System.out.println(arr[index]);
    }

    public void postOrder() {
        this.postOrder(0);
    }
}