// https://leetcode.com/problems/number-of-islands

package number_of_islands_0200;

public class Solution {
    boolean[][] parsedGrid;

    public int numIslands(char[][] grid) {
        int result = 0;
        parsedGrid = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (parsedGrid[i][j]) {
                    continue;
                }

                if (grid[i][j] == '1') {
                    result++;
                    parseIsland(grid, i, j);
                } else {
                    parsedGrid[i][j] = true;
                }
            }
        }

        return result;
    }

    public void parseIsland(char[][] grid, int i, int j) {
        if (parsedGrid[i][j]) {
            return;
        }

        parsedGrid[i][j] = true;

        if (i > 0 && grid[i - 1][j] == '1') {
            parseIsland(grid, i - 1, j);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1') {
            parseIsland(grid, i + 1, j);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            parseIsland(grid, i, j - 1);
        }
        if (j < grid[i].length - 1 && grid[i][j + 1] == '1') {
            parseIsland(grid, i, j + 1);
        }
    }
}
