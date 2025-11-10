package cn.bravedawn.jd.jd_141;

/**
 * @Author : depers
 * @Date : Created in 2025-11-10 17:06
 */
public class Solution {


    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
