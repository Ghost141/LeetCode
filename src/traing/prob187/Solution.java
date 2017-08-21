package traing.prob187;

import java.util.*;

/**
 * Repeated DNA Sequences
 * Link: https://leetcode.com/problems/repeated-dna-sequences/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/21/17
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> strCount = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if (strCount.containsKey(sub)) {
                if (strCount.get(sub) == 1) {
                    list.add(sub);
                    strCount.put(sub, strCount.get(sub) + 1);
                }
            } else strCount.put(sub, 1);
        }

        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
