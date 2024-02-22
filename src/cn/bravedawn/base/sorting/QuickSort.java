package cn.bravedawn.base.sorting;

import java.util.Arrays;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/2/21 16:46
 *
 * 移动挖坑算法
 */
public class QuickSort {

    public static void quickSort(int[] nums, int low, int high) {

        if (low < high) {
            int index = partition(nums, low, high);
            quickSort(nums, low, index - 1);
            quickSort(nums, index + 1, high);
        }

    }

    /**
     * 一次分区排序
     * @param nums 数组
     * @param low 最左下标
     * @param high 最右下标
     * @return
     */
    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];

        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            if (low < high) {
                nums[low] = nums[high];
            }

            while (low < high && nums[low] <= pivot) {
                low++;
            }
            if (low < high) {
                nums[high] = nums[low];
            }
        }

        nums[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
