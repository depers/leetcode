package cn.bravedawn.jd_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : fengx9
 * @Project : leetcode
 * @Date : Created in 2024-01-24 14:38
 *
 * 1.两数之和
 */
public class Solution {


    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));


        int[] nums2 = {3,2,4,};
        int target2 = 7;
        System.out.println(Arrays.toString(twoSum(nums2, target2)));
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }


}
