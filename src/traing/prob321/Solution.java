package traing.prob321;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Create Maximum Number
 * Link: https://leetcode.com/problems/create-maximum-number/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/21/17
 */
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int n = nums1.length;
        int m = nums2.length;
        for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, res, 0)) res = candidate;
        }
        return res;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return res;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++; j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private int[] maxArray(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[k];
        for (int i = 0; i < nums.length; i++) {
            while (stack.size() + nums.length - i > k && !stack.isEmpty() && stack.peek() < nums[i]) stack.pop();
            if (stack.size() < k) stack.push(nums[i]);
        }
        for (int i = k - 1; i >= 0; i--) res[i] = stack.pop();
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.greater(new int[] {1, 2}, 0, new int[] {1, 1, 3}, 0));
    }
}
