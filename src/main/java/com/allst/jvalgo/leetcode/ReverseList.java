package com.allst.jvalgo.leetcode;

/**
 * No.1
 * 链表反转:
 * 1 > 2 > 3 > 4 > 5
 * 由上面的链表转换为： 5 > 4 > 3 > 2 > 1
 *
 * @author June
 * @since 2021年05月
 */
public class ReverseList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 方法1：迭代
    public static ListNode iterate(ListNode head) {
        ListNode prev = null, next;
        ListNode curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 方法2： 递归
    public static ListNode recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 初始节点
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        // 但断点查看详情
        recursion(node1);
    }
}
