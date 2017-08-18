package traing.prob119;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle II
 * Link: https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/18/17
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        int prev = 0;
        for (int i = 0; i < rowIndex + 1; i++) row.add(0);

        for (int i = 1; i <= rowIndex + 1; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = row.get(j);
                if (j == i - 1) row.set(j, 1);
                else row.set(j, prev + row.get(j));
                prev = tmp;
            }
            prev = 0;
        }
        return row;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.getRow(1));
        System.out.println(s.getRow(2));
        System.out.println(s.getRow(3));
        System.out.println(s.getRow(4));
        System.out.println(s.getRow(5));
        System.out.println(s.getRow(6));
    }
}
