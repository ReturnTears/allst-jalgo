package com.allst.jvalgo.leetcode;

/**
 * 二叉树的深度优先算法
 *
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
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 获取二叉树的最小深度
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
}
