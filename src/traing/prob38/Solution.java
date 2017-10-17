package traing.prob38;

/**
 * Count and Say
 * Link: https://leetcode.com/problems/count-and-say/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/17/17
 */
public class Solution {
    public String countAndSay(int n) {
        String str = "1";

        while (n - 1 != 0) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < str.length();) {
                int count = 1;
                while (i + count < str.length() && str.charAt(i + count - 1) == str.charAt(i + count)) count++;
                builder.append(count).append(str.charAt(i));
                i += count;
            }
            n--;
            str = builder.toString();
        }
        return str;
    }
}
