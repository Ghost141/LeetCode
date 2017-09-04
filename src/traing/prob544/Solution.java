package traing.prob544;

import java.util.ArrayList;
import java.util.List;

/**
 * Output Contest Matches
 * Link: https://leetcode.com/problems/output-contest-matches/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/4/17
 */
public class Solution {
    public String findContestMatch(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(String.valueOf(i + 1));
        }
        List<String> list1 = list;
        int left = 0, right = list1.size() - 1;

        List<String> nextRound = new ArrayList<>();
        while (list1.size() != 1) {
            String pair = "(" + list1.get(left++) + "," + list1.get(right--) + ")";
            nextRound.add(pair);
            if (left > right) {
                list1 = nextRound;
                nextRound = new ArrayList<>();
                left = 0;
                right = list1.size() - 1;
            }
        }
        return list1.get(0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findContestMatch(8));
    }
}
