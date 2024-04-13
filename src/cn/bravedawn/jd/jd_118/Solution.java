package cn.bravedawn.jd.jd_118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/7 16:34
 *
 * 118. 杨辉三角
 */
public class Solution {

    /**
     * 第一行：1
     * 第二行：1，1
     * 第三行：1，2，1
     * 第四行：1，3，3，1
     * 第五行：1，4，6，4，1
     *
     * 这里有两个规律
     * 第一个：每一行数据的第一个位置和最后一个位置都是1
     * 第二个：其他位置等于上一行数据的前一个位置+上一行数据的当前位置
     */

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        // i表示当前行
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            // j表示当前的位置
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i-1).get(j-1) + ret.get(i-1).get(j));
                }
            }
            ret.add(row);
        }

        return ret;
    }


    public static void main(String[] args) {
        System.out.println(generate(5));
    }

}
