// https://leetcode.com/problems/append-characters-to-string-to-make-subsequence
package append_characters_to_string_to_make_subsequence_2486;

class Solution {
    public int appendCharacters(String s, String t) {
        char[] sq1 = s.toCharArray();
        char[] sq2 = t.toCharArray();

        int index = 0;

        for (int i = 0; i < sq1.length; i++) {
            if (sq1[i] == sq2[index]) {
                index++;

                if (index == sq2.length) {
                    return 0;
                }
            }
        }

        return sq2.length - index;
    }
}