package cn.bravedawn.zd.zd_406;

import java.util.*;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/7/23 22:34
 *
 * 406. 根据身高重建队列
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] result = solution.reconstructQueue(people);
        System.out.println("result = " + Arrays.deepToString(result));
    }

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return  b[0] - a[0];
            }
        });

        System.out.println("sort array: " + Arrays.deepToString(people));

        LinkedList<int[]> list = new LinkedList<>();

        for (int i = 0; i < people.length; i++) {
            int position = people[i][1];
            list.add(position, people[i]);
        }

        return list.toArray(new int[list.size()][]);

    }

}
