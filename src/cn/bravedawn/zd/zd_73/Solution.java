package cn.bravedawn.zd.zd_73;

import java.util.Arrays;

/**
 * @Author : fengx9
 * @Project : leetcode-main
 * @Date : Created in 2024-03-29 16:09
 *
 * 73.矩阵置零
 */
public class Solution {


    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }


    public static void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;


        boolean[] rows = new boolean[rowLen];
        boolean[] cols = new boolean[colLen];

        for (int i = 0; i < rowLen; i++) {

            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < rowLen; i++) {

            for (int j = 0; j < colLen; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
