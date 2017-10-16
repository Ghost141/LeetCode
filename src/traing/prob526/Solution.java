package traing.prob526;

/**
 * Beautiful Arrangement
 * Link: https://leetcode.com/problems/beautiful-arrangement/description/
 *
 * @author zhaokai
 * @version 1.1 - Better backtracking. 1) Backtrack from the end. The higher number got more chance to fail. 2) swap the number instead of using a boolean array.
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
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                    visited[i] = true;
                    _backtrack(pos + 1, N, visited, count);
                    visited[i] = false;
                }
            }
        }
    }

    private int betterBacktrack(int N) {
        int[] num = new int[N + 1];
        for (int i = 1; i <= N; i++) num[i] = i;
        int[] count = new int[1];
        _betterBacktrack(num, N, count);
        return count[0];
    }

    private void _betterBacktrack(int[] num, int start, int[] count) {
        if (start == 0) count[0]++;
        else {
            for (int i = start; i > 0; i--) {
                swap(num, start, i);
                if (num[start] % start == 0 || start % num[start] == 0) _betterBacktrack(num, start - 1, count);
                swap(num, i, start);
            }
        }
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countArrangement(2));
        System.out.println(s.countArrangement(3));
        System.out.println(s.countArrangement(4));
    }
}
