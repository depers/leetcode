package cn.bravedawn.zd.zd_560;

/**
 * @Author : fengx9
 * @Project : leetcode-main
 * @Date : Created in 2024-03-29 11:03
 *
 * 560.和为 K 的子数组
 */
public class Solution {


    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        System.out.println(subarraySum(nums, k));
    }


    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
