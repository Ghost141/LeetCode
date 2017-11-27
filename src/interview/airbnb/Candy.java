package interview.airbnb;

import java.util.Arrays;

/**
 * Link:
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/27/17
 */
public class Candy {
    public int candy(int[] nums) {
        int[] candies = new int[nums.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) candies[i] = candies[i - 1] + 1;
        }
        int sum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            sum += nums[i];
        }
        return sum;
    }
}
