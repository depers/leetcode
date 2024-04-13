package cn.bravedawn.zd.zd_55;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/31 10:32
 *
 * 55.跳跃游戏
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        canJump(nums);
    }


    /**
     * i+nums[i]表示之前每次跳一步和当前位置可跳跃的长度
     * k表示目前最远可以跳跃的长度
     * 如果当前这一步大于我可以跳跃的最远长度，那就说明跳不到了
     */
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (i > k) {
                return false;
            }
            k = Math.max(k, i + nums[i]);
        }
        return true;

    }

}
