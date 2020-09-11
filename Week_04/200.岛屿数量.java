import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        Map<Integer, Boolean> rowMap = new HashMap<>();
        int count = 0;
        for (int col = 0; col < grid.length; col++) {
            for (int row = 0; row < grid[col].length; row++) {
                if (grid[col][row] == '1') {
                    count++;
                    dfs(col, row, grid);
                }
            }
        }
        return count;
    }

    void dfs(int col, int row, char[][] grid) {
        grid[col][row] = '0';
        if (row > 0 && grid[col][row - 1] == '1') { // 左
            dfs(col, row - 1, grid);
        }
        if ((row + 1) < grid[0].length && grid[col][row + 1] == '1') { // 右
            dfs(col, row + 1, grid);
        }
        if (col > 0 && grid[col - 1][row] == '1') { // 上
            dfs(col - 1, row, grid);
        }
        if ((col + 1) < grid.length && grid[col + 1][row] == '1') { // 下
            dfs(col + 1, row, grid);
        }
    }
}
// @lc code=end
