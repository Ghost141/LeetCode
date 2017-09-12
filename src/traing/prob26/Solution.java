package traing.prob26;

import utils.DataGenerator;
import utils.PrintUtils;

/**
 * Remove Duplicates from Sorted Array
 * Link:
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/12/17
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        for (int i = 1, j = 0; i < nums.length; i++) {
            if (nums[i] == nums[j]) {
                len--;
            } else {
                j++;
                nums[j] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Solution s = new Solution();


//        int[] arr1 = DataGenerator.createIntArray("1,1,2");
//        System.out.println(s.removeDuplicates(arr1));
//        PrintUtils.printai(arr1);
//        int[] arr2 = DataGenerator.createIntArray("1,1,2,2,3");
//        System.out.println(s.removeDuplicates(arr2));
//        PrintUtils.printai(arr2);

        int[] arr2 = DataGenerator.createIntArray("0,0,0,0,0,1,2,2,3,3,4,4");
        System.out.println(s.removeDuplicates(arr2));
        PrintUtils.printai(arr2);
    }
}
