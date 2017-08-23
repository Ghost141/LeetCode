package traing.prob42;

import utils.DataGenerator;

/**
 * Trapping Rain Water
 * Link: https://leetcode.com/problems/trapping-rain-water/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/23/17
 */
public class Solution {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int area = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    area += leftMax - height[left];
                }
                left++;
            } else {
                if (rightMax < height[right]) {
                    rightMax = height[right];
                } else {
                    area += rightMax - height[right];
                }
                right--;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.trap(DataGenerator.createIntArray("4,2,3")));
    }
}
