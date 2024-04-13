package cn.bravedawn.zd.zd_11;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/8 09:58
 *
 * 11. 盛最多水的容器
 */
public class Solution {

    // height = [1,8,6,2,5,4,8,3,7]

    public static int maxArea(int[] height) {

        int max = 0;
        int left = 0;
        int len = height.length;
        int right = len - 1;

        while (left < right) {

            // 计算容量
            int capacity = (right - left) * (height[right] > height[left] ? height[left] : height[right]);
            if (capacity > max) {
                max = capacity;
            }

            // 容量其实和短板相关，谁短谁移动
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = maxArea(height);
        System.out.println(result);
    }
}
