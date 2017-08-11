package traing.prob293;

import java.util.ArrayList;
import java.util.List;

/**
 * Flip Game
 * Link: https://leetcode.com/problems/flip-game/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/11/17
 */
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        char cur, prev = ' ';
        for (int i = 0; i < s.length(); i++) {
            cur = s.charAt(i);
            if (cur == prev) {
                char[] chars = s.toCharArray();
                if (cur == '+') {
                    chars[i] = chars[i - 1] = '-';
                    res.add(new String(chars));
                }
            }

            prev = cur;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.generatePossibleNextMoves("-+--+"));
    }
}
