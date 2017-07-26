package traing.prob11;

/**
 * Container With Most Water
 * Link:https://leetcode.com/problems/container-with-most-water/#/description
 *
 * @author zhaokai
 */
public class Solution {
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int start = 0, end = height.length - 1;
        int max = 0;
        while (start != end) {
            max = Math.max(max, (end - start) * Math.min(height[start], height[end]));
            if (height[start] >= height[end]) end--;
            else start++;
        }
        return max;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println(s.maxArea(new int[] {}));
        System.out.println(s.maxArea(new int[] {1}));
        System.out.println(s.maxArea(new int[] {1, 2}));
    }
}
