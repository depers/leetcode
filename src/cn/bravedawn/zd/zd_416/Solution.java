package cn.bravedawn.zd.zd_416;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/7/11 21:39
 *
 * 416.分割等和子集
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        boolean res = canPartition(nums);
        System.out.println(res);
    }


    public static boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        // 如果sun不能整除2，则说明不能拆分成相等的两部分
        if (sum % 2 == 1) {
            return false;
        }
        // 背包的大小就是和的一半
        int target = sum / 2;

        // dp代表装满容量为i的包，所能容下的最大的物品数量
        int[] dp = new int[target + 1];

        for (int i = 0; i < nums.length; i++) { // 遍历物品
            for (int j = target; j >= nums[i]; j--) { // 遍历背包
                // dp是一轮一轮从上往下算的
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }

            if (dp[target] == target) {
                return true;
            }
        }

        if (dp[target] == target) {
            return true;
        }

         return false;
    }
}
