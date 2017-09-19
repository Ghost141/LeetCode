package traing.prob161;

/**
 * One Edit Distance
 * Link: https://leetcode.com/problems/one-edit-distance/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/19/17
 */
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) return s.substring(i + 1).equals(t.substring(i + 1));
                else if (s.length() < t.length()) return s.substring(i).equals(t.substring(i + 1));
                else return s.substring(i + 1).equals(t.substring(i));
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.isOneEditDistance("", ""));
//        System.out.println(s.isOneEditDistance("", "a"));
//        System.out.println(s.isOneEditDistance("ab", "ba"));
//        System.out.println(s.isOneEditDistance("a", "ba"));
        System.out.println(s.isOneEditDistance("ab", "acb"));
    }
}
