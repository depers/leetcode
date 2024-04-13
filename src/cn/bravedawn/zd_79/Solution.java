package cn.bravedawn.zd_79;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/4/13 14:14
 *
 * 79.单词搜索
 * 这道题可以参考200题，但是不同的是这个题是一个矩阵的深度优先遍历的算法，我理解这个不是一个回溯的问题。是矩阵的深度优先遍历。
 */
public class Solution {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";


        System.out.println(exist(board, word));
    }


    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    boolean result = dfs(board, i, j, word, 0);
                    if (result) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    private static boolean dfs(char[][] grid, int r, int c, String word, int index) {
        // 判断 base case
        if (!inArea(grid, r, c) || index >= word.length()) {
            return false;
        }

        char t = grid[r][c];
        boolean result = false;
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] == word.charAt(index)) {

            if (index == word.length() - 1) {
                return true;
            }

            grid[r][c] = '.'; // 将格子标记为「已遍历过」
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int i = 0; i < directions.length; i++) {
                // 访问上、下、左、右四个相邻结点
                boolean flag = dfs(grid, r + directions[i][0], c + directions[i][1], word, index+1);
                if (flag) {
                    result = true;
                    break;
                }
            }
        }
        grid[r][c] = t;
        return result;
    }


    // 判断坐标 (r, c) 是否在网格中
    private static boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }
}
