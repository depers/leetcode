package cn.bravedawn.zd.zd_54;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : fengx9
 * @Project : leetcode-main
 * @Date : Created in 2024-03-29 16:25
 * <p>
 * 54.螺旋矩阵
 */
public class Solution {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0) {
            return result;
        }

        // 明确边界
        int top = 0;
        int below = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            // 向右走
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }

            // 向下走
            if (top < below) {
                top++;
            } else {
                break;
            }
            for (int i = top; i <= below; i++) {
                result.add(matrix[i][right]);
            }

            // 向左走
            if (right > left) {
                right--;
            } else {
                break;
            }
            for (int i = right; i >= left; i--) {
                result.add(matrix[below][i]);
            }

            // 向上走
            if (below > top) {
                below--;
            } else {
                break;
            }
            for (int i = below; i >= top; i--) {
                result.add(matrix[i][left]);
            }

            // 向右走
            if (left < right) {
                left++;
            } else {
                break;
            }

        }
        return result;
    }
}
