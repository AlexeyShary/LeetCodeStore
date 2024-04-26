// https://leetcode.com/problems/minimum-falling-path-sum-ii

package minimum_falling_path_sum_ii_1289;

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int size = grid.length;

        int[][] sumGrid = new int[size][size];

        for (int i = 0; i < size; i++) {
            sumGrid[0][i] = grid[0][i];
        }

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int minSum = Integer.MAX_VALUE;

                for (int k = 0; k < size; k++) {
                    if (k == j) {
                        continue;
                    }

                    minSum = Math.min(minSum, sumGrid[i-1][k] + grid[i][j]);
                }

                sumGrid[i][j] = minSum;
            }
        }

        int result = sumGrid[size-1][0];

        for (int i = 1; i < size; i++) {
            result = Math.min(result, sumGrid[size-1][i]);
        }

        return result;
    }
}