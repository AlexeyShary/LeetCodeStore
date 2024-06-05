// https://leetcode.com/problems/find-common-characters
package find_common_characters_1002;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[] resultFreqMap = new int[128];

        for(int i = 0; i < words[0].length(); i++) {
            resultFreqMap[words[0].charAt(i)] += 1;
        }

        for(int i = 1; i < words.length; i++) {
            int[] freqMap = new int[128];

            for(int j = 0; j < words[i].length(); j++) {
                freqMap[words[i].charAt(j)] += 1;
            }

            for (int j = 97; j < 123; j++) {
                resultFreqMap[j] = Math.min(resultFreqMap[j], freqMap[j]);
            }
        }

        for (int i = 97; i < 123; i++) {
            for (int j = 0; j < resultFreqMap[i]; j++) {
                result.add(Character.toString((char) i));
            }
        }

        return result;
    }
}