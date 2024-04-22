// https://leetcode.com/problems/longest-palindromic-substring/

package longest_palindromic_substring_0005;

public class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);

        String result = sb.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String s1 = checkWithCenterAsSymbol(sb, i);
            String s2 = checkWithCenterInBetween(sb, i);

            if (result.length() < s1.length()) {
                result = s1;
            }

            if (result.length() < s2.length()) {
                result = s2;
            }
        }

        return result;
    }

    String checkWithCenterAsSymbol(StringBuilder s, int center) {
        int left, right;
        left = right = center;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }

    String checkWithCenterInBetween(StringBuilder s, int center) {
        int left, right;
        left = center;
        right = center + 1;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
