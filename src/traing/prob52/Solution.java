package traing.prob52;

import java.util.HashSet;
import java.util.Set;

/**
 * N-Queens II
 * Link: https://leetcode.com/problems/n-queens-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/14/17
 */
public class Solution {
    private Set<Integer> col = new HashSet<>();
    private Set<Integer> dia = new HashSet<>();
    private Set<Integer> anDia = new HashSet<>();
    public int totalNQueens(int n) {
        return count(0, n);
    }

    private int count(int row, int n) {
        if (row == n) return 1; // find one;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isValid(row, i, n)) {
                col.add(i);
                dia.add(row - i);
                anDia.add(row + i);
                count += count(row + 1, n);
                col.remove(i);
                dia.remove(row - i);
                anDia.remove(row + i);
            }
        }
        return count;
    }

    private boolean isValid(int i, int j, int n) {
        if (col.contains(j)) return false;
        if (dia.contains(i - j)) return false;
        if (anDia.contains(i + j)) return false;
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.totalNQueens(5));
    }
}
