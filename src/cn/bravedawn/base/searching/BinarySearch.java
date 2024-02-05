package cn.bravedawn.base.searching;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/2/5 11:14
 */
public class BinarySearch {


    public static int binarySearch(Integer[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        // Just generate data
        Random r = ThreadLocalRandom.current();

        int size = 100;
        int maxElement = 100000;

        Integer[] integers = IntStream.generate(() -> r.nextInt(maxElement)).limit(size).sorted().boxed().toArray(Integer[] ::new);
        // The element that should be found
        int shouldBeFound = integers[r.nextInt(size - 1)];

        int result = binarySearch(integers, shouldBeFound, 0, integers.length);
        System.out.println("nums = " + Arrays.toString(integers));
        System.out.println("target=" + shouldBeFound);
        System.out.println("result=" + result);

    }


}
