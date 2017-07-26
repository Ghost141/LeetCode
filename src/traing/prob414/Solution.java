package traing.prob414;

/**
 * Link:
 *
 * @author zhaokai
 */
public class Solution {
    public int thirdMax(int[] nums) {
        Integer max1 = null, max2 = null, max3 = null;
        int updateCount = 0;
        for (Integer num : nums) {
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) continue;
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
                updateCount++;
            } else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
                updateCount++;
            } else if (max3 == null || num > max3) {
                max3 = num;
                updateCount++;
            }
        }
        return max3 == null ? max1 : max3;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.thirdMax(new int[]{-2147483648, -2147483648, -2147483648, -2147483648, 1, 1, 1}));
    }
}
