package traing.prob459;

/**
 * Repeated Substring Pattern
 *
 * @author zhaokai
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        final int n = s.length();
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {
                int m = n / i;
                final String repetedString = s.substring(0, i);
                int j;
                for (j = 1; j < m; j++) {
                    if (!s.substring(j * i, i + j * i).equals(repetedString)) break;
                }
                if (j == m) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println(s.repeatedSubstringPattern("abab"));
    }
}
