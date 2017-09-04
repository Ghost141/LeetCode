package traing.prob243;

/**
 * Shortest Word Distance
 * Link: https://leetcode.com/problems/shortest-word-distance/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/4/17
 */
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        String s = null;
        for (String word : words) {
            if (s == null && (word.equals(word1) || word.equals(word2))) {
                s = word;
                count = 0;
            } else {
                if (word.equals(s)) {
                    count = 0; // Reset
                } else if (!word.equals(s) && (word.equals(word1) || word.equals(word2))) {
                    min = Math.min(min, count);
                    s = word;
                    count = 0;
                }
            }
            count++;
        }
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes", "practice"}, "coding", "practice"));
//        System.out.println(s.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding"));
        System.out.println(s.shortestDistance(new String[]{"this", "is", "a", "long", "sentence", "is", "fun", "day",
                "today", "sunny", "weather", "is", "a", "day", "tuesday", "this", "sentence", "run", "running", "rainy"},
                "a", "sentence"));
    }
}
