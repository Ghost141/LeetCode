package traing.prob318;

/**
 * Maximum Product of Word Lengths
 * Link: https://leetcode.com/problems/maximum-product-of-word-lengths/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/31/17
 */
public class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        int n = words.length;
        int[] wordValues = new int[n];
        for (int i = 0; i < n; i++) {
            String w = words[i];
            for (int j = 0; j < w.length(); j++)
                wordValues[i] |= 1 << (w.charAt(j) - 'a');
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((wordValues[i] & wordValues[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }

}
