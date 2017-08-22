package traing.prob660;

/**
 * Remove 9
 * Link: https://leetcode.com/problems/remove-9/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/22/17
 */
public class Solution {
    public int newInteger(int n) {
        return Integer.parseInt(Integer.toString(n, 9));
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.newInteger(9));
    }
}
