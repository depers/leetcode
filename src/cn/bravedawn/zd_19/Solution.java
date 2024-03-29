package cn.bravedawn.zd_19;

import java.util.List;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/29 20:05
 *
 * 19.删除链表的倒数第 N 个结点
 */
public class Solution {


    public static void main(String[] args) {
        // ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        // int n = 2;

        ListNode node = new ListNode(1);
        int n = 1;
        ListNode head = removeNthFromEnd(node, n);

        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 这个变量很重要，在只有一个节点，而且n也是1的时候十分有用
        ListNode dummy = new ListNode(0, head);

        int len = getLen(head);

        ListNode node = dummy;

        for (int i = 1; i < len - n + 1; i++) {
            node = node.next;
        }

        node.next = node.next.next;
        head = dummy.next;

        return head;
    }


    public static int getLen(ListNode head) {
        int len = 0;

        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }

        return len;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
