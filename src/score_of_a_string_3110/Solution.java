// https://leetcode.com/problems/score-of-a-string
package score_of_a_string_3110;

class Solution {
    public int scoreOfString(String s) {
        int result = 0;

        char[] chars = s.toCharArray();
        char current = chars[0];

        for (int i = 1; i < chars.length; i++) {
            result += Math.abs(current - chars[i]);
            current = chars[i];
        }

        return result;
    }
}