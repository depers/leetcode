package cn.bravedawn.zd.zd_347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/9/11 22:14
 *
 * 347.前K个高频元素
 */
public class Solution2 {

    public int topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> occurrence = new HashMap<>();
        for (int num : nums) {
            occurrence.put(num, occurrence.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });


        for (Map.Entry<Integer, Integer> entry : occurrence.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            }
        }
    }
}
