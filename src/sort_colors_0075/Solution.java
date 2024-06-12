// https://leetcode.com/problems/sort-colors
package sort_colors_0075;

class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int current = 0;

        while (current <= right) {
            if (nums[current] == 0) {
                if (current == left) {
                    current++;
                } else {
                    int tmp = nums[current];
                    nums[current] = nums[left];
                    nums[left] = tmp;
                }
                left++;
            } else if (nums[current] == 2) {
                if (current == right) {
                    current++;
                } else {
                    int tmp = nums[current];
                    nums[current] = nums[right];
                    nums[right] = tmp;
                }
                right--;
            } else {
                current++;
            }
        }
    }
}