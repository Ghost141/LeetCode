package traing.prob60;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutation Sequence
 * Link: https://leetcode.com/problems/permutation-sequence/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/17/17
 */
public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = i * factorial[i - 1];
            numbers.add(i);
        }


        for (int i = 1; i <= n; i++) {
            int ind = (k - 1) / factorial[n - i];
            res.append(numbers.get(ind));
            numbers.remove(ind);
            k -= ind * factorial[n - i];
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.getPermutation(3, 2));
    }
}
