package cn.bravedawn.zd.zd_287;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/10/12 20:59
 *
 * 287.寻找重复数
 */
public class Solution {

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        // 慢指针走一步
        slow = nums[slow];
        // 块指针走两步
        fast = nums[nums[fast]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int tmp = 0;
        while (tmp != slow) {
            tmp = nums[tmp];
            slow = nums[slow];
        }
        return tmp;
    }
}
