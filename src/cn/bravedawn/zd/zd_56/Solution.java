package cn.bravedawn.zd.zd_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/6 22:28
 *
 * 56. 合并区间
 */
public class Solution {

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{0,4}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }


    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> arr = new ArrayList<>();
        arr.add(intervals[0]);

        for(int i = 1, j = 0; i < intervals.length && j < arr.size(); ) {
            if(arr.get(j)[1] >= intervals[i][0]){
                int two = arr.get(j)[1] > intervals[i][1] ? arr.get(j)[1] : intervals[i][1];
                int[] r = {arr.get(j)[0], two};
                arr.set(j, r);
                i++;
            } else {
                // 不存在合并动作，移动res数组下标
                j++;
                arr.add(intervals[i]);
                i++;
            }
        }
        return arr.toArray(new int[arr.size()][]);
    }
}
