package cn.bravedawn.jd.jd_160;

/**
 * @Author : depers
 * @Date : Created in 2025-10-27 09:31
 */
public class Solution {

    /**
     * 160. 相交链表
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p = headA;
        ListNode q = headB;

        /**
         * headA到相交节点的距离为 x
         * headB到相交节点的距离为 y
         * 相交节点到尾节点的距离为 z
         *
         * 则 (x + z) + y = (y + z) + x
         */

        while (q != p) {
            p = p != null ? p.next : headB;
            q = q != null ? q.next : headA;
        }
        return p;
    }
}
