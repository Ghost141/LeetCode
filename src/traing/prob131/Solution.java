package traing.prob131;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Partitioning
 * Link: https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/22/17
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        m(list, new ArrayList<>(), s, 0);
        return list;
    }

    private void m(List<List<String>> list, List<String> tmp, String s, int start) {
        if (start == s.length()) list.add(new ArrayList<>(tmp));


        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                tmp.add(s.substring(start, i + 1));
                m(list, tmp, s, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        int i = start, j = end;
        while (i < j)
            if (s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.partition("aab"));
    }
}
