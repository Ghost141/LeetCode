package traing.prob55;

/**
 * Jump Game
 *
 * @author zhaokai
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int numsLength = nums.length;
        int[] reach = new int[numsLength];

        reach[0] = 1;

        for (int i = 0; i < numsLength - 1; i++) {
            if (nums[i] != 0) {
                int farthest = i + nums[i];
                for (int start = i + 1; start <= farthest; start++ ) {
                    reach[Math.min(start, numsLength - 1)] = 1;
                }
            }
        }

        for (int i = 0; i < reach.length; i++) {
            if (reach[i] == 0) return false;
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
