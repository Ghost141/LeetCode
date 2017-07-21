package traing.prob229;

import java.util.*;

/**
 * Majority Element II
 *
 * @author zhaokai
 */
public class Solution {

    public List<Integer> majorityElement(int[] nums) {
        int counter1 = 0, counter2 = 0;
        Integer majority1 = 0, majority2 = 0;
        Set<Integer> res = new HashSet<>();

        for (int num : nums) {
            if (majority1 == num) {
                counter1++;
            } else if (majority2 == num) {
                counter2++;
            } else if (counter1 == 0) {
                majority1 = num;
                counter1++;
            } else if (counter2 == 0) {
                majority2 = num;
                counter2++;
            } else {
                counter1--;
                counter2--;
            }
        }
        counter1 = 0; counter2 = 0;
        for (int num : nums) {
            if (num == majority1) {
                counter1++;
            } else if (num == majority2) {
                counter2++;
            }
        }
        if (counter1 > nums.length / 3) {
            res.add(majority1);
        }
        if (counter2 > nums.length / 3) {
            res.add(majority2);
        }

        return Arrays.asList(res.toArray(new Integer[0]));
    }

    public static void main(String[] args) {
        final Solution s = new Solution();
        for (Integer integer : s.majorityElement(new int[]{8, 8, 7, 7, 7})) {
            System.out.println(integer);
        }
    }
}
