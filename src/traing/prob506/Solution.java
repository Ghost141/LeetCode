package traing.prob506;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Relative Ranks
 * Link: https://leetcode.com/problems/relative-ranks/tabs/description/
 *
 * @author zhaokai
 */
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[] rank = nums.clone();
        Arrays.sort(rank);
        Map<Integer, Integer> map = new HashMap<>();
        int length = rank.length;
        for (int i = 0; i < length; i++) {
            map.put(rank[i], length - i);
        }
        String[] result = new String[length];
        for (int i = 0; i < nums.length; i++) {
            String r = "";
            Integer numRank = map.get(nums[i]);
            if (numRank == 1) {
                r = "Gold Medal";
            } else if (numRank == 2) {
                r = "Silver Medal";
            } else if (numRank == 3) {
                r = "Bronze Medal";
            } else {
                r = String.valueOf(numRank);
            }
            result[i] = r;
        }

        return result;
    }
}
