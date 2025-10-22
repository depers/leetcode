package cn.bravedawn.jd.jd_21.v1;

/**
 * @Author : depers
 * @Date : Created in 2025-10-22 09:59
 */
public class Solution {

    /**
     * 21. 合并两个有序链表
     */


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }


    public static void main(String[] args) {
        // l1 = [1,2,4], l2 = [1,3,4]
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode node = mergeTwoLists(l1, l2);
        while (node != null) {
            int val = node.val;
            System.out.print(val + "->");
            node = node.next;
        }
    }
}
