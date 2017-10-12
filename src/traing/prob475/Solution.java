package traing.prob475;

import utils.DataGenerator;

import java.util.Arrays;

/**
 * Heaters
 * Link: https://leetcode.com/problems/heaters/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/12/17
 */
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = 0;
        for (int house : houses) {
            int ind = Arrays.binarySearch(heaters, house);
            if (ind < 0) {
                ind = ~ind;
                int dis1 = ind - 1 >= 0 ? house - heaters[ind - 1] : Integer.MAX_VALUE;
                int dis2 = ind < heaters.length ? heaters[ind] - house : Integer.MAX_VALUE;
                res = Math.max(res, Math.min(dis1, dis2));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.findRadius(DataGenerator.createIntArray("1,2,3"), DataGenerator.createIntArray("2")));
//        System.out.println(s.findRadius(DataGenerator.createIntArray("1,5"), DataGenerator.createIntArray("2")));
        System.out.println(s.findRadius(DataGenerator.createIntArray("1,1,1,1,1,1,999,999,999,999,999"), DataGenerator.createIntArray("499,500,501")));
    }
}
