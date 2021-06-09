package com.allst.jvalgo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的深度优先算法：把叶子节点标记为1
 * 二叉树的广度优先算法：把root节点标记为1
 *
 * @author June
 * @since 2021年06月
 */
public class TreeDeep {
    public static void main(String ...args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, node7, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println(minDept(node1));
        System.out.println(minDept2(node1));
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        int deep;
        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 获取二叉树的最小深度：深度优先算法
     * 空间复杂度O(logn)
     *
     * @param root 树节点
     * @return 结果
     */
    private static int minDept(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDept(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDept(root.right), min);
        }
        return min + 1;
    }

    /**
     * 获取二叉树的最小深度: 广度优先算法
     * 空间复杂度O(n)
     *
     * @param root 树节点
     * @return 结果
     */
    private static int minDept2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        root.deep = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                return node.deep;
            }
            if (node.left != null) {
                node.left.deep = node.deep + 1;
                queue.offer(node.left);
            }
            if (node.right != null) {
                node.right.deep = node.deep + 1;
                queue.offer(node.right);
            }
        }
        return 0;
    }
}
