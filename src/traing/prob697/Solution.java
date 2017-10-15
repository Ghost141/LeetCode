package traing.prob697;

import utils.DataGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * Degree of an Array
 * Link:
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/15/17
 */
public class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int len = Integer.MAX_VALUE, fre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] arr = map.get(nums[i]);
                arr[1]++;
                if (arr[1] == fre) len = Math.min(len, i - arr[0] + 1);
                else if (arr[1] > fre) len = i - arr[0] + 1;
                fre = Math.max(fre, arr[1]);
            } else {
                map.put(nums[i], new int[] {i, 1});
            }
        }
        return len == Integer.MAX_VALUE ? 1 : len;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findShortestSubArray(DataGenerator.createIntArray("1,2,2,3,1,4,2")));
    }
}
