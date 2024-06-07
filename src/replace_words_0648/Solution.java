// https://leetcode.com/problems/replace-words
package replace_words_0648;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        boolean isFirstWord = true;

        for (String word : words) {
            if (!isFirstWord) {
                sb.append(" ");
            }
            isFirstWord = false;

            sb.append(filterV2(dictionary, word));
        }

        return sb.toString();
    }

    public String filter(List<String> dictionary, String word, int index) {
        if (dictionary.isEmpty()) {
            return word;
        }

        List<String> nextStepCandidates = new ArrayList<>();

        for (String candidate : dictionary) {
            if (candidate.charAt(index) == word.charAt(index)) {
                if (candidate.length() > index + 1) {
                    nextStepCandidates.add(candidate);
                } else {
                    return candidate;
                }
            }
        }

        if (word.length() == index + 1) {
            return word;
        }

        return filter(nextStepCandidates, word, ++index);
    }

    public String filterV2(List<String> dictionary, String word) {
        String result = word;

        for (String candidate : dictionary) {
            for (int index = 0; index < word.length(); index++) {
                if (index < candidate.length()) {
                    if (candidate.charAt(index) == word.charAt(index)) {
                        if (candidate.length() == index + 1) {
                            if (candidate.length() < result.length()) {
                                result = candidate;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
