package cn.bravedawn.zd.zd_621;

import java.util.Arrays;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/9 20:57
 *
 * 621. 任务调度器
 */
public class Solution {


    public static int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }


        Arrays.sort(count);
        // 相同个数的字母有几组
        int maxCount = 0;
        for (int i = 25; i >= 0; i--) {
            // 统计相同个数的字母有几组
            if (count[i] != count[25]) {
                break;
            }
            maxCount++;
        }

        // 遵守下面这个规则
        // n == 0, tasks.length
        // n != 0, (count[25] - 1) * (n + 1) + maxCount
        return Math.max((count[25] - 1) * (n + 1) + maxCount, tasks.length);
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }
}
