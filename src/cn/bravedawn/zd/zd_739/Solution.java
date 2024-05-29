package cn.bravedawn.zd.zd_739;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/5/29 08:28
 *
 * @apiNote  739.每日温度
 *
 * @see @link <a href="https://programmercarl.com/0739.%E6%AF%8F%E6%97%A5%E6%B8%A9%E5%BA%A6.html">代码随想录-739.每日温度</a>
 */
public class Solution {

    /**
     * 采用单调栈来说实现，这里我们采用的是递增栈，就是从栈头到栈底，从上往下是等增的
     * 我们比较的是数组元素右边较大的元素，所以是递增栈
     */

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[temperatures.length];
        deque.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] < temperatures[deque.peek()]) {
                deque.push(i);
            } else if (temperatures[i] == temperatures[deque.peek()]) {
                deque.push(i);
            } else {
                // temperatures[i] > temperatures[deque.peek()]
                while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peek()]) {
                    result[deque.peek()] = i - deque.peek();
                    deque.pop();
                }
                deque.push(i);
            }
        }
        return result;
    }

}
