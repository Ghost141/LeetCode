package traing.prob657;

/**
 * Judge Route Circle
 * Link: https://leetcode.com/problems/judge-route-circle/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/18/17
 */
public class Solution {
    public boolean judgeCircle(String moves) {
        int[] m = new int[2];
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'R') m[0]++;
            else if (c == 'L') m[0]--;
            else if (c == 'U') m[0]++;
            else if (c == 'D') m[0]--;
        }
        return m[0] == 0 && m[1] == 0;
    }
}
