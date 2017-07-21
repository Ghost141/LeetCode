package traing.prob219;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains Duplicate II
 * Link: https://leetcode.com/problems/contains-duplicate-ii/#/description
 *
 * @author zhaokai
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> val2Ind = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            List<Integer> indList;
            if (val2Ind.containsKey(val)) {
                indList = val2Ind.get(val);
                for (Integer ind : indList) {
                    if (i - ind <= k) {
                        return true;
                    }
                }
            } else {
                indList = new ArrayList<>();
            }
            indList.add(i);
            val2Ind.put(val, indList);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.containsNearbyDuplicate(new int[] {-1, -1}, 1));
    }
}
