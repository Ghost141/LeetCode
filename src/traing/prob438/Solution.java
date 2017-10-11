package traing.prob438;

import java.util.*;

/**
 * Find All Anagrams in a String
 * Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * @author zhaokai
 * @version 1.0 - TLE
 * @since 1.0 - 6/27/17
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int j = 0; j < p.length(); j++) {
            final String c = p.substring(j, j + 1);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            int offset = 0;
            Map<String, Integer> subMap = new HashMap<>();
            for (int j = 0; j < p.length(); j++) {
                int searchInd = i + offset;
                final String si = s.substring(searchInd, searchInd + 1);

                Integer subCount = subMap.get(si);
                subCount = subCount == null ? 0 : subCount;
                if (p.contains(si) && subCount + 1 <= map.get(si)) {
                    subMap.put(si, subCount + 1);
                } else {
                    break;
                }

                offset++;
                if (j == p.length() - 1) {
                    result.add(i);
                }
            }
        }
        return result;
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
