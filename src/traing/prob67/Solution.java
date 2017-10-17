package traing.prob67;

/**
 * Add Binary
 * Link: https://leetcode.com/problems/add-binary/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/17/17
 */
public class Solution {
    public String addBinary(String a, String b) {
        final StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum & 1);
            carry = (sum >> 1) & 1;
        }
        return sb.reverse().toString();
    }
}
