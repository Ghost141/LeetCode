package traing.prob242;

/**
 * Problem 242. Valid anagram
 * @author zhaokai
 */
public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        boolean result = true;
        for (int i = 0; i < counter.length; i++) {
            result = result && counter[i] == 0;
        }

        return result;
    }
}
