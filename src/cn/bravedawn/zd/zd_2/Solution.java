package cn.bravedawn.zd.zd_2;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/2/29 21:50
 *
 * 2. 两数相加
 */
public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = null;
        ListNode head = null;
        int num = 0;
        while (l1 != null || l2 != null || num != 0) {
            int a = 0, b = 0;
            if (l1 == null) {
                a = 0;
            } else {
                a = l1.val;
            }
            if (l2 == null) {
                b = 0;
            } else {
                b = l2.val;
            }
            int result = a + b + num;
            if (res == null) {
                res = new ListNode(result % 10);
                head = res;
            } else {
                ListNode n = new ListNode(result % 10);
                res.next = n;
                res = res.next;
            }

            num = result / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return head;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;


        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        addTwoNumbers(n1, l1);
    }
}
