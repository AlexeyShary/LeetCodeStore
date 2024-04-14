// https://leetcode.com/problems/longest-substring-without-repeating-characters/

package longest_substring_without_repeating_0003;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int currentLength = 0;

        int leftIndex = 0;

        int[] charTable = new int[128];

        for (int rightIndex = 0; rightIndex < s.length(); rightIndex++) {
            Character c = s.charAt(rightIndex);

            if (charTable[c] == 0) {
                charTable[c] = 1;
            } else {
                maxLength = Math.max(maxLength, currentLength);

                for (int i = leftIndex; i <= rightIndex; i++) {
                    Character lc = s.charAt(i);

                    currentLength--;
                    leftIndex = i + 1;

                    if (c.equals(lc)) {
                        break;
                    } else {
                        charTable[lc] = 0;
                    }
                }
            }

            currentLength++;
        }

        return Math.max(maxLength, currentLength);
    }
}