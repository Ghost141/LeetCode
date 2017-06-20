package traing.prob1;

import java.util.HashMap;

import static traing.Utils.printai;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        final int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            if (map.containsKey(target - num)) {
                res[1] = i;
                res[0] = map.get(target - num);
            }

            map.put(num, i);
        }


        return res;
    }

    public static void main(String[] args) {
        final Solution so = new Solution();
        printai(so.twoSum(new int[]{3, 2, 4}, 6));
    }
}
