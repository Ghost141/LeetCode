package traing.prob453;

/**
 * Minimum Moves to Equal Array Elements
 * Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/31/17
 */
public class Solution {
    public int minMoves(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            min = Math.min(num, min);
            sum += num;
        }
        return sum - min * nums.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minMoves(new int[] {1, 2, 3}));
    }
}
