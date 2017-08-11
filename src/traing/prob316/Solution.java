package traing.prob316;

/**
 * Remove Duplicate Letters
 * Link: https://leetcode.com/problems/remove-duplicate-letters/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/11/17
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        char[] strChars = s.toCharArray();

        for (char c : strChars) count[c - 'a']++;

        for (char c : strChars) {
            int ind = c - 'a';
            count[ind]--;
            if (visited[ind]) continue;

            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && count[getLastAlphInd(sb)] > 0) {
                visited[getLastAlphInd(sb)] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(c);
            visited[ind] = true;
        }

        return sb.toString();
    }

    private int getLastAlphInd(StringBuilder sb) {
        return sb.charAt(sb.length() - 1) - 'a';
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.removeDuplicateLetters("bbcaac"));
    }
}
