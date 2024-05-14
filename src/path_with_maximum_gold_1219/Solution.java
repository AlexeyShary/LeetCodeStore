// https://leetcode.com/problems/path-with-maximum-gold
package path_with_maximum_gold_1219;

class Solution {
    int[] roww = {1, -1, 0, 0};
    int[] coll = {0, 0, -1, 1};

    public int dfs(int[][] grid, int y, int x) {
        if (x < 0 || x >= grid[0].length || y < 0 || y >= grid.length || grid[y][x] == 0) return 0;

        int curr = grid[y][x];
        grid[y][x] = 0;
        int localMaxGold = curr;

        for (int i = 0; i < 4; i++) {
            int newX = x + roww[i];
            int newY = y + coll[i];
            localMaxGold = Math.max(localMaxGold, curr + dfs(grid, newY, newX));
        }

        grid[y][x] = curr;
        return localMaxGold;
    }

    public int getMaximumGold(int[][] grid) {
        int result = 0;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] != 0) {
                    result = Math.max(result, dfs(grid, y, x));
                }
            }
        }

        return result;
    }
}