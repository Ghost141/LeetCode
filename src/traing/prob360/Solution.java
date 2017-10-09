package traing.prob360;

/**
 * Sort Transformed Array
 * Link: https://leetcode.com/problems/sort-transformed-array/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/9/17
 */
public class Solution {
    private int a, b, c;
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        int[] res = new int[nums.length];
        int ind = a >= 0 ? nums.length - 1 : 0;
        int left = 0, right = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (a >= 0)
                res[ind--] = f(nums[left]) >= f(nums[right]) ? f(nums[left++]) : f(nums[right--]);
            else
                res[ind++] = f(nums[left]) <= f(nums[right]) ? f(nums[left++]) : f(nums[right--]);
        }
        return res;
    }

    private int f(int x) {
        return a * x * x + b * x + c;
    }
}
