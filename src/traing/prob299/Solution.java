package traing.prob299;

/**
 * Bulls and Cows
 * Link: https://leetcode.com/problems/bulls-and-cows/description/
 *
 * @author zhaokai
 * @version 1.0
 * @version 1.1 - One pass and no map involved solution.
 * @since 1.0 - 9/25/17
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] nums = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) bulls++;
            else {
                if (nums[s]++ < 0) cows++;
                if (nums[g]-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getHint("1123", "0111"));
    }
}
