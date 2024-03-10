package cn.bravedawn.zd_15;

import java.nio.file.Paths;
import java.util.*;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/10 22:07
 *
 * 15. 三数之和
 */
public class Solution {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        int left, right;
        int len = nums.length;

        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return result;
            }

            // 去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            left = i + 1;
            right = len - 1;

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 去重复
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }

        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));;
    }
}
