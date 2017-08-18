package traing.prob118;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle
 * Link: https://leetcode.com/problems/pascals-triangle/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/18/17
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 1; i <= numRows; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < i; j++) {
                if (j == i - 1) {
                    res.get(i - 1).add(1);
                } else {
                    res.get(i - 1).add(start + row.get(j));
                    start = row.get(j);
                }
            }
            start = 0;
            row = res.get(i - 1);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.generate(5));
    }
}
