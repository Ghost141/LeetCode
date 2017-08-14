package traing.prob548;

import java.util.HashSet;
import java.util.Set;

/**
 * Split Array with Equal Sum
 * Link: https://leetcode.com/problems/split-array-with-equal-sum/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/14/17
 */
public class Solution {
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        if (n < 7) return false;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int ind = 1; ind < nums.length; ind++) {
            sum[ind] = sum[ind - 1] + nums[ind];
        }

        for (int j = 3; j < n - 3; j++) {
            Set<Integer> set = new HashSet<>();

            for (int i = 1; i < j - 1; i++) {
                if (sum[i - 1] == sum[j - 1] - sum[i]) {
                    set.add(sum[i - 1]);
                }
            }
            for (int k = j + 2; k < n - 1; k++) {
                if (sum[k - 1] - sum[j] == sum[n - 1] - sum[k] && set.contains(sum[k - 1] - sum[j])) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.splitArray(new int[] {1, 2, -1, 1, 2, 5, 2, 5, 2}));
    }
}
