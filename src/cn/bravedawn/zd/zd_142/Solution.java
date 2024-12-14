package cn.bravedawn.zd.zd_142;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/5/6 21:29
 *
 * 142.环形链表II
 *
 * 推演过程：
 * 假设x是链表头结点到环起始节点的距离，y是环的起始节点到相遇节点（快指针和慢指针在环内相遇节点）的距离，z是相遇节点到环起始节点的距离
 * 因为快指针每次走两步，慢指针走一步
 * 则慢指针行走的距离是x+y，快指针行走的距离是x+y+n(y+z)，这里的n指的是快指针转的圈数
 * 则得出等式：2(x+y) = x+y+n(y+z)，最后推导出x=(n-1)(y+z)+z，这里的n是大于等于1的
 * 经过推到发现快指针肯定是在转了一圈之后就遇到了慢指针，所以这里n为1得到x=z
 *
 * 代码随想录：https://programmercarl.com/0142.%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8II.html#%E6%80%9D%E8%B7%AF
 * B站视频：https://www.bilibili.com/video/BV1if4y1d7ob/?spm_id_from=333.999.0.0
 */
public class Solution {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // 说明快指针和慢指针在环内相遇了
            if (fast == slow) {
                // 寻找环的起始节点
                ListNode index = head;
                // 当x=z时，开始寻找环的入口，如果快慢指针相遇的节点不是在x=z的位置相遇的话，需要快慢指针每次各走一步寻找环的入口
                while (index != slow) {
                    index = index.next;
                    slow = slow.next;
                }
                // 找到环的起点了
                return index;
            }
        }
        return null;
    }
}
