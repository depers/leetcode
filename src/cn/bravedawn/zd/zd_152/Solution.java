package cn.bravedawn.zd.zd_152;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/6/12 08:37
 * <p>
 * 152.乘积最大子数组
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
        System.out.println(maxProduct(new int[]{-2,3,-4}));
    }

    /**
     * 错误的实现，没有考虑到存在两个负值的情况
     * @param nums
     * @return
     */
    public static int maxProduct_error(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] * nums[i], nums[i]);
        }
        int max = dp[nums.length - 1];
        for (int i = nums.length-2; i >= 0; i--) {
            max = Math.max(max, dp[i]);

        }
        return max;
    }

    public static int maxProduct(int[] nums) {
        // 初始化
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;

        for (int num : nums) {
            if (num < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            max = Math.max(max, imax);
        }

        return max;
    }
}
