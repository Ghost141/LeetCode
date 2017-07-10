package traing.prob1;

import java.util.Arrays;

public class Solution2 {

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();

        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

}
