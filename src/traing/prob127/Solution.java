package traing.prob127;

import java.util.*;

/**
 * Word Ladder
 * Link: https://leetcode.com/problems/word-ladder/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/28/17
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        boolean[] used = new boolean[wordList.size()];
        int length = 1, start = 0, end = 1, level = 1;

        while (start != end) {
            String word = list.get(start);
            for (int i = 0; i < wordList.size(); i++) {
                String s = wordList.get(i);
                if (!used[i] && isOneLetterDiff(s, word)) {
                    if (s.equals(endWord)) {
                        return length + 1;
                    }
                    list.add(s);
                    used[i] = true;
                    end++;
                }
            }
            start++;
            if (level == start) {
                level = end;
                length++;
            }
        }

        return 0;
    }

    private boolean isOneLetterDiff(String word1, String word2) {
        boolean diff = false;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (diff) return false;
                else diff = true;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
