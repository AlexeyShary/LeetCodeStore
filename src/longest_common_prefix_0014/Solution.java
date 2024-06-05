// https://leetcode.com/problems/longest-common-prefix/
package longest_common_prefix_0014;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = strs[0];

        if (result.length() == 0) {
            return result;
        }

        for (int i = 1; i < strs.length; i++) {
            result = result.substring(0, Math.min(strs[i].length(), result.length()));

            for (int j = 0; j < strs[i].length(); j++) {
                if (j < result.length() && result.charAt(j) == strs[i].charAt(j)) {
                    continue;
                } else {
                    result = result.substring(0, j);
                    break;
                }
            }

            if (result.length() == 0) {
                return result;
            }
        }

        return result;
    }
}