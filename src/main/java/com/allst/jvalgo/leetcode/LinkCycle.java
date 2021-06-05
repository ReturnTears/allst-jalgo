package com.allst.jvalgo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 * 给定一个链表， 判断链表中是否有环。如果链表中有某个节点，可以通过连续跟踪next指针再次到达该节点，则链表中存在环
 *
 * @author June
 * @since 2021年06月
 */
public class LinkCycle {
    public static void main(String ...args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node5.next = node3;
        System.out.println(hasCycle(node1));
        System.out.println(hasCycle2(node1));
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 时间复杂度,空间复杂度都是O(n)
     *
     * @param head 头部节点
     * @return 结果： 是否存在环 true 是 false 否
     */
    private static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 双指针算法求解：
     * 时间复杂度O(n),空间复杂度没有
     *
     * @param head  头部节点
     * @return  结果： 是否存在环 true 是 false 否
     */
    private static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != quick) {
            if (quick == null || quick.next == null) {
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }
}
