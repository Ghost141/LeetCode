package traing.prob137;

/**
 * Single Number II
 * Link: https://leetcode.com/problems/single-number-ii/description/
 *
 * There is a good discussion about this solution here: https://discuss.leetcode.com/topic/2031/challenge-me-thx/17
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/5/17
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}
