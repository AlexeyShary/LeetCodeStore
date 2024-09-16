// https://leetcode.com/problems/minimum-time-difference
package minimum_time_difference_0539;

import java.util.Arrays;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int result = 1440;
        int[] times = new int[timePoints.size()];

        int c = 0;
        for (String s : timePoints) {
            String[] parts = s.split(":");
            times[c] = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
            c++;
        }

        Arrays.sort(times);
        for (int i = 0; i < times.length - 1; i++) {
            result = Math.min(result, times[i+1] - times[i]);
        }
        return Math.min(result, Math.abs(1440 - times[times.length - 1] + times[0]));
    }
}