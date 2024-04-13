package cn.bravedawn.zd.zd_153;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/30 09:51
 *
 * 153. 寻找旋转排序数组中的最小值
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                // 最小值是pivot左侧的元素，忽略右侧
                high = pivot;
            } else {
                // >= 说明最小值是pivot右侧的元素，忽略左侧
                // 这里如果不+1的话，这个循环就走不出去，也就是说范围不能被缩小
                low = pivot + 1;
            }
        }
        return nums[low];
    }
}
