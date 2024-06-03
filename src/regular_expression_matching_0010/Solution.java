// https://leetcode.com/problems/regular-expression-matching/
package regular_expression_matching_0010;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isMatch(String s, String p) {
        return isMatchHelper(s, p, 0, 0, new HashMap<>());
    }

    private boolean isMatchHelper(String s, String p, int i, int j, Map<String, Boolean> memo) {
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (j == p.length()) {
            return i == s.length();
        }

        boolean firstMatch = (i < s.length() &&
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

        boolean result;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            result = (isMatchHelper(s, p, i, j + 2, memo) ||
                    (firstMatch && isMatchHelper(s, p, i + 1, j, memo)));
        } else {
            result = firstMatch && isMatchHelper(s, p, i + 1, j + 1, memo);
        }

        memo.put(key, result);
        return result;
    }
}
