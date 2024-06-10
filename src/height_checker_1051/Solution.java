// https://leetcode.com/problems/height-checker
package height_checker_1051;

import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        int result = 0;
        int[] sorted = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sorted);

        for (int i = 0; i < sorted.length; i++) {
            if (heights[i] != sorted[i]) {
                result++;
            }
        }

        return result;
    }
}