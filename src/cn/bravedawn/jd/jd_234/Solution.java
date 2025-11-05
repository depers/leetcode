package cn.bravedawn.jd.jd_234;

/**
 * @Author : depers
 * @Date : Created in 2025-11-05 17:33
 */
public class Solution {

    public static void main(String[] args) {
        boolean result = isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))));
        System.out.println(result);
    }

    public static boolean isPalindrome(ListNode head) {
        // 找到链表的中间节点
        ListNode mid = middleNode(head);

        // 对中间链表后面的半段链表进行反转
        ListNode head2 = reverseList(mid);

        // 如果链表长度是偶数，从中间截断的后半部分链表会少一个节点，所有要判断他是否为空
        while (head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }

        return true;
    }

    // 876.链表的中间节点
    private static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 206.翻转链表
    private static ListNode reverseList(ListNode head) {
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
