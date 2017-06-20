package traing.prob167;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        final int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            if (map.containsKey(target - num)) {
                res[1] = i + 1;
                res[0] = map.get(target - num);
            }

            map.put(num, i + 1);
        }
        return res;
    }
}
