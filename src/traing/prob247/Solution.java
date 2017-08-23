package traing.prob247;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Strobogrammatic Number II
 * Link: https://leetcode.com/problems/strobogrammatic-number-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/23/17
 */
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return build(n, n);
    }

    private List<String> build(int m, int target) {
        if (m == 0) return new ArrayList<>(Arrays.asList(""));
        if (m == 1) return Arrays.asList("1", "8", "0");
        List<String> prev = build(m - 2, target);
        List<String> list = new ArrayList<>();
        for (String s : prev) {
            if (m != target) list.add("0" + s + "0");
            list.add("1" + s + "1");
            list.add("8" + s + "8");
            list.add("6" + s + "9");
            list.add("9" + s + "6");
        }

        return list;
    }
}
