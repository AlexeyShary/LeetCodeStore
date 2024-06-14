// https://leetcode.com/problems/minimum-increment-to-make-array-unique
package minimum_increment_to_make_array_unique_0945;

class Solution {
    public int minIncrementForUnique(int[] nums) {
        int result = 0;

        int max = nums.length;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] freqMap = new int[max + nums.length];

        for (int num : nums) {
            freqMap[num]++;
        }

        for (int i = 0; i < freqMap.length; i++) {
            if (freqMap[i] > 1) {
                freqMap[i + 1] += freqMap[i] - 1;
                result += freqMap[i] - 1;
            }
        }

        return result;
    }
}