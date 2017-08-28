package traing.prob127;

import java.util.*;

/**
 * Word Ladder
 * Link: https://leetcode.com/problems/word-ladder/description/
 *
 * @author zhaokai
 * @version 1.0
 * @version 1.1 - Double-end BFS solution
 * @since 1.0 - 8/28/17
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), dic = new HashSet<>(wordList)
                , visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int step = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> tmp = new HashSet<>();
            for (String str : beginSet) {
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String transformed = String.valueOf(chars);
                        if (endSet.contains(transformed)) return step + 1;
                        if (dic.contains(transformed) && visited.add(transformed)) {
                            dic.remove(transformed);
                            tmp.add(transformed);
                        }
                    }
                }
            }
            step++;
            beginSet = tmp;
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
