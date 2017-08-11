package traing.prob294;

/**
 * Flip Game II
 * Link: https://leetcode.com/problems/flip-game-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/11/17
 */
public class Solution {

    public boolean canWin(String s) {
        return backtrack(s);
    }

    private boolean backtrack(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i), c2 = s.charAt(i + 1);
            if (c1 == '+' && c2 == '+') {
                char[] chars = s.toCharArray();
                chars[i] = chars[i + 1] = '-';
                boolean isWin = !backtrack(new String(chars));
                if (isWin) return true;
            }
        }
        return false;
    }
}
