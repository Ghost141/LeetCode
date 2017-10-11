package traing.prob438;

import java.util.*;

/**
 * Find All Anagrams in a String
 * Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * @author zhaokai
 * @version 1.0 - TLE
 * @version 1.1 - Accepted. Sliding window tech.
 * @since 1.0 - 6/27/17
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() == 0 || p.length() == 0 || p.length() > s.length()) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        int[] window = new int[26];
        for (int i = 0; i < p.length(); i++) {
            window[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']--;
        }

        for (int i = p.length(); i < s.length(); i++) {
            if (allZero(window)) result.add(i - p.length());
            window[s.charAt(i) - 'a']--;
            window[s.charAt(i - p.length()) - 'a']++;
        }
        if (allZero(window)) result.add(s.length() - p.length());

        return result;
    }
    private boolean allZero(int[] nums) {
        for (int num : nums) if (num != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println(s.findAnagrams("cbaebabacd", "abc"));
        System.out.println(s.findAnagrams("abab", "ab"));
        System.out.println(s.findAnagrams("", "ab"));
        System.out.println(s.findAnagrams("123", "ab"));
        System.out.println(s.findAnagrams("baa", "aa"));
        System.out.println(s.findAnagrams("", "aba"));
    }
}
