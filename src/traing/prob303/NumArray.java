package traing.prob303;

/**
 * Range Sum Query - Immutable
 * Link: https://leetcode.com/problems/range-sum-query-immutable/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/15/17
 */
public class NumArray {
    private int[] sum;
    public NumArray(int[] nums) {
        int n = nums.length;
        sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {
        NumArray n = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});

        System.out.println(n.sumRange(0, 2));
        System.out.println(n.sumRange(2, 5));
        System.out.println(n.sumRange(0, 5));
    }
}
