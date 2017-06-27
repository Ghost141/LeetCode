package traing.prob153;

public class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, middle = (start + end) / 2;
        while (start != end) {
            if (nums[middle] < nums[end]) {
                end = middle;
            } else {
                start = middle + 1;
            }
            middle = (start + end) / 2;
        }
        return nums[middle];
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        s.findMin(new int[] {1});
    }
}
