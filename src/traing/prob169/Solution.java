package traing.prob169;

/**
 * Majority Element
 *
 * @author zhaokai
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int counter = 0, majority = 0;
        for (int num : nums) {
            if (counter == 0) {
                majority = num;
                counter++;
            } else if (majority == num) {
                counter++;
            } else counter--;
        }

        return majority;
    }
}
