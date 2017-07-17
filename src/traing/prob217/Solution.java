package traing.prob217;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem 217. Contains Duplicate.
 *
 * @author zhaokai
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            if (sets.contains(num)) return true;
            sets.add(num);
        }
        return false;
    }
}
