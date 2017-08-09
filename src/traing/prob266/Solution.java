package traing.prob266;

/**
 * Palindrome Permutation
 * Link: https://leetcode.com/problems/palindrome-permutation/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/9/17
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] codes = new int[256];
        for (int i = 0; i < s.length(); i++) {
            codes[s.charAt(i)]++;
        }

        int oddCount = 0;
        for (int i = 0; i < codes.length; i++) {
            if (codes[i] % 2 == 1) {
                oddCount++;
            }
        }

        return oddCount == 0 || oddCount == 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.canPermutePalindrome("AaBb//a"));
    }
}
