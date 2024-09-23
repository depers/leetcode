package cn.bravedawn.zd.zd_240;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/9/23 21:45
 *
 * 240.搜索二维矩阵 II（贪心算法）
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        // i是行下标，j是列下标
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--; // 行往上
            }
            else if (matrix[i][j] < target) {
                j++; // 列往右
            } else {
                return true;
            }
        }
        return false;
    }
}
