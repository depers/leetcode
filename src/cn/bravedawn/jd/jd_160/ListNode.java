package cn.bravedawn.jd.jd_160;


/**
 * @Author : depers
 * @Date : Created in 2025-10-27 09:28
 */
public class ListNode {

    protected int val;
    protected ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode listNode) {
        this.val = val;
        this.next = listNode;
    }
}
