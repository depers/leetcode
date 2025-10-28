package cn.bravedawn.jd.jd_206;

/**
 * @Author : depers
 * @Date : Created in 2025-10-28 10:11
 */
public class Solution {


    /**
     * 206.翻转链表
     */

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reverseList = reverseList(listNode);
        while (reverseList != null) {
            System.out.print(reverseList.val + "->");
            reverseList = reverseList.next;
        }
    }


    /**
     * 头插法
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null; // 这个是新的listNode
        ListNode cur = head; // 这个是原来的listNode
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre; // 把 cur 插在 pre 链表的前面（头插法）
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
