package traing.prob526;

import java.util.HashSet;
import java.util.Set;

/**
 * Beautiful Arrangement
 * Link: https://leetcode.com/problems/beautiful-arrangement/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/16/17
 */
public class Solution {
    public int countArrangement(int N) {
        return backtrack(N);
    }

    private int backtrack(int N) {
        int[] count = new int[1];
        boolean[] visited = new boolean[N + 1];
        _backtrack(1, N, visited, count);
        return count[0];
    }

    private void _backtrack(int pos, int N, boolean[] visited, int[] count) {
        if (pos > N) count[0]++;
        else {
            for (int i =1;i <= N; i++) {
                if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                    visited[i] = true;
                    _backtrack(pos + 1, N, visited, count);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countArrangement(2));
        System.out.println(s.countArrangement(3));
        System.out.println(s.countArrangement(4));
    }
}
