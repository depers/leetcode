package cn.bravedawn.base.sorting;

import java.util.Arrays;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/2/21 16:46
 * <p>
 * 交换算法
 */
public class QuickSort2 {

    public static void quickSort(int[] nums, int low, int high) {

        if (low < high) {
            int index = partition(nums, low, high);
            quickSort(nums, low, index - 1);
            quickSort(nums, index + 1, high);
        }

    }

    /**
     * 一次分区排序
     *
     * @param nums 数组
     * @param low  最左下标
     * @param high 最右下标
     * @return
     */
    public static int partition(int[] nums, int low, int high) {

        int pivot = nums[low];
        int start = low;

        while (low < high) {
            // 找到右侧小于pivot值
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            // 找到左侧小于pivot值
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            if (low >= high) {
                break;
            }
            // 置换位置
            swap(nums, low, high);
        }
        // 基准值归位
        swap(nums, start, low);
        return low;
    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
