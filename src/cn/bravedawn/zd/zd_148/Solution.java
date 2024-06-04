package cn.bravedawn.zd.zd_148;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/6/2 12:01
 *
 * @apiNote 148.链表排序，通过快排的思路进行实现
 * @see <a href="https://www.cnblogs.com/morethink/p/8452914.html">Java实现单链表的快速排序和归并排序</a>
 */
public class Solution {

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
        quickSort(head, null);
        return head;
    }

    private void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode node = partion(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    private ListNode partion(ListNode head, ListNode end) {
        ListNode p1 = head, p2 = head.next;

        // p1的值作为key，后续元素都与该key元素作比较
        while (p2 != end) {
            // 当大于key的值时，p1往前走一步，交互p1和p2的值
            if (p2.val < head.val) {
                p1 = p1.next;

                int temp = p1.val;
                p1.val = p2.val;
                p2.val = temp;
            }
            p2 = p2.next;
        }

        // 当有序时，交互p1和key的值
        if (p1 != head) {
            int temp = p1.val;
            p1.val = head.val;
            head.val = temp;
        }

        return p1;
    }
}
