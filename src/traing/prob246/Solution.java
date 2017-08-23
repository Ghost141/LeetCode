package traing.prob246;

/**
 * Strobogrammatic Number
 * Link: https://leetcode.com/problems/strobogrammatic-number/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/23/17
 */
public class Solution {
    public boolean isStrobogrammatic(String num) {
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            char opC = num.charAt(num.length() - i - 1);
            if ((c == '7' || c == '3' || c == '4' || c == '2' || c == '5')
                    || (c == '6' && opC != '9') || (c == '9' && opC != '6') || (c == '1' && opC != '1')
                    || (c == '8' && opC != '8') || (c == '0' && opC != '0')
                    ) return false;
        }
        return true;
    }
}
