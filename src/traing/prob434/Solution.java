package traing.prob434;

/**
 * Number of Segments in a String
 * Link: https://leetcode.com/problems/number-of-segments-in-a-string/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/31/17
 */
public class Solution {
    public int countSegments(String s) {
        if (s == null) return 0;
        int count = 0;
        boolean word = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (word) {
                    count++;
                    word = false;
                }
            } else {
                word = true;
            }
        }
        if (word) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countSegments("abc"));
        System.out.println(s.countSegments(""));
        System.out.println(s.countSegments("abc edf"));
        System.out.println(s.countSegments("abc edf "));
        System.out.println(s.countSegments("abc edf "));
        System.out.println(s.countSegments("Hello, my name is john "));
    }
}
