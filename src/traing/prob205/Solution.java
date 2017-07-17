package traing.prob205;

/**
 * Isomorphic Strings
 * @author zhaokai
 */
public class Solution {
    /**
     * Idea from https://discuss.leetcode.com/topic/13001/short-java-solution-without-maps/2.
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256], m2 = new int[256];


        for (int i = 0; i < s.length(); i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }
            m1[s.charAt(i)] = m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isIsomorphic("ab", "aa"));
        System.out.println(s.isIsomorphic("aa", "aa"));
    }
}
