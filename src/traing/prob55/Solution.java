package traing.prob55;

/**
 * Jump Game
 * Link: https://leetcode.com/problems/jump-game/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/18/17
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int maxLocation = 0;

        for (int i = 0; i < nums.length; i++) {
            if (maxLocation < i) return false;
            if (maxLocation >= nums.length) return true;
            maxLocation = Math.max(maxLocation, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println(s.canJump(new int[]{2, 0}));
        System.out.println(s.canJump(new int[]{0, 0}));
        System.out.println(s.canJump(new int[]{0}));
        System.out.println(s.canJump(new int[]{3}));
        System.out.println(s.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(s.canJump(new int[]{1, 0, 1, 0}));
    }
}
