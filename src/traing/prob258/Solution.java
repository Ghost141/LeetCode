package traing.prob258;

/**
 * Add Digits
 * Link: https://leetcode.com/problems/add-digits/description/
 *
 * Wiki Link: https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/1/17
 */
public class Solution {
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
