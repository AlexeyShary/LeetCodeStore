// https://leetcode.com/problems/largest-local-values-in-a-matrix
package largest_local_values_in_a_matrix_2373;

class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] result = new int[grid.length - 2][grid.length - 2];

        for(int i = 1; i < grid.length - 1; ++i) {
            for(int j = 1; j < grid.length - 1; ++j) {
                int maxValue = 0;

                for(int k = i - 1; k <= i + 1; ++k) {
                    for(int l = j - 1; l <= j + 1; ++l) {
                        maxValue = Math.max(maxValue, grid[k][l]);
                    }
                }

                result[i - 1][j - 1] = maxValue;
            }
        }

        return result;
    }
}