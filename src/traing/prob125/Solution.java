package traing.prob125;

/**
 * Valid Palindrome
 * Link: https://leetcode.com/problems/valid-palindrome/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/10/17
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.trim().length() == 0) return true;
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j;) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!Character.isLetterOrDigit(ci)) {
                i++;
            } else if (!Character.isLetterOrDigit(cj)) {
                j--;
            } else {
                if (ci != cj) {
                    return false;
                }
                i++;
                j--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
