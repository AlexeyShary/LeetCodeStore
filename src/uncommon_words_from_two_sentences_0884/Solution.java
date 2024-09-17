// https://leetcode.com/problems/uncommon-words-from-two-sentences
package uncommon_words_from_two_sentences_0884;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> freqMap = new HashMap<>();

        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");

        for (String word : words1) {
            if (!word.isBlank()) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        for (String word : words2) {
            if (!word.isBlank()) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        int c = 0;
        for (Map.Entry<String, Integer> kv : freqMap.entrySet()) {
            if (kv.getValue().equals(1)) {
                c++;
            }
        }

        String[] m = new String[c];
        int i = 0;
        for (Map.Entry<String, Integer> kv : freqMap.entrySet()) {
            if (kv.getValue().equals(1)) {
                m[i] = kv.getKey();
                i++;
            }
        }

        return m;
    }
}

/*
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> freqMap = new HashMap<>();

        String[] words = (s1 + " " + s2).split(" ");
        for (String word : words) {
            if (!word.isBlank()) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> kv : freqMap.entrySet()) {
            if (kv.getValue().equals(1)) {
                result.add(kv.getKey());
            }
        }

        return result.toArray(String[]::new);
    }
}*/
