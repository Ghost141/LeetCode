package traing.prob599;

import java.util.*;

/**
 * Minimum Index Sum of Two Lists
 *
 * @author zhaokai
 */
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> list1IndexMap = new HashMap<>();
        List<String> res = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            list1IndexMap.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            final Integer j = list1IndexMap.get(list2[i]);

            if (j != null && i + j <= minSum) {
                final int indexSum = i + j;
                if (indexSum < minSum) {
                    res = new ArrayList<>();
                    minSum = indexSum;
                }
                res.add(list2[i]);
            }
        }

        return res.toArray(new String[res.size()]);
    }
}
