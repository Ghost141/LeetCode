package traing.prob696;

/**
 * Count Binary Substrings
 * Link:
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/15/17
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int count0 = 0, count1 = 0;
            for (int j = i; j < s.length(); j++) {
                if (j > i && s.charAt(j) != s.charAt(j - 1) && count1 > 0 && count0 > 0) break;
                if (s.charAt(j) == '1') count1++;
                else count0++;
                if (count0 == count1) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countBinarySubstrings("00110"));
    }
}
