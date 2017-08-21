package traing.prob179;

import utils.DataGenerator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Largest Number
 * Link: https://leetcode.com/problems/largest-number/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/20/17
 */
public class Solution {
    public String largestNumber(int[] nums) {
        String[] data = new String[nums.length];
        for (int i = 0; i < nums.length; i++) data[i] = String.valueOf(nums[i]);
        Comparator<String> comparator = (o1, o2) -> {
            String s1 = o1, s2 = o2;
            int l1 = o1.length();
            int l2 = o2.length();

            for (int i = 0; i < (l1 + l2); i++) {
                if (i >= l1) s1 = o2;
                else if (i >= l2) s2 = o1;
                char c1 = s1.charAt(i % l1);
                char c2 = s2.charAt(i % l2);
                if (c1 > c2) return 1;
                else if (c1 < c2) return -1;
            }
            return 0;
        };

        Arrays.sort(data, comparator);
        StringBuilder sb = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) sb.append(data[i]);

        return data[nums.length - 1].equals("0") ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.largestNumber(DataGenerator.createIntArray("12,128")));
        System.out.println(s.largestNumber(DataGenerator.createIntArray("12,121")));
        System.out.println(s.largestNumber(DataGenerator.createIntArray("543,5435")));
        System.out.println(s.largestNumber(DataGenerator.createIntArray("5435,543")));
        System.out.println(s.largestNumber(DataGenerator.createIntArray("12,1211")));
        System.out.println(s.largestNumber(DataGenerator.createIntArray("0,0,00")));
        System.out.println(s.largestNumber(DataGenerator.createIntArray("0,0,1")));
        System.out.println(s.largestNumber(DataGenerator.createIntArray("1")));
    }
}
