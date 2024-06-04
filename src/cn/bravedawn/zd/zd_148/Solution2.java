package cn.bravedawn.zd.zd_148;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/6/2 12:24
 *
 * @apiNote 148.链表排序，通过归并排序的思路进行实现
 * @see <a href="https://www.cnblogs.com/morethink/p/8452914.html">Java实现单链表的快速排序和归并排序</a>
 */
public class Solution2 {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 获取中间节点
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        return mergeSort(sortList(head), sortList(right));
    }

    private ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeSort(ListNode head1, ListNode head2) {
        ListNode p1 = head1, p2 = head2, head;

        if (head1.val < head2.val) {
            head = head1;
            p1 = p1.next;
        } else {
            head = head2;
            p2 = p2.next;
        }

        ListNode p = head;
        // 比较链表中的值
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return head;
    }
}
