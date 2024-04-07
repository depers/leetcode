package cn.bravedawn.zd_64;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/4/7 22:04
 *
 * 64.最小路径和
 */
public class Solution {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int result = minPathSum(grid);
        System.out.println(result);
    }

    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }

            }
        }
        return grid[rows - 1][cols - 1];
    }
}
