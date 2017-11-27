package interview.airbnb;

/**
 * Airbnb interview question: Split Array Largest Sum.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/27/17
 */
public class SplitArrayLargestSum {
    public int split(int[] nums, int k) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(num, left);
            right += num;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (splitable(nums, k, mid)) right = mid - 1;
            else right = left + 1;
        }

        return left;
    }

    private boolean splitable(int[] nums, int k, int target) {
        long sum = 0;
        int count = 1;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                sum = num;
                if (++count > k) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum s = new SplitArrayLargestSum();

        System.out.println(s.split(new int[]{1, 2, 3, 4}, 2));
    }
}
