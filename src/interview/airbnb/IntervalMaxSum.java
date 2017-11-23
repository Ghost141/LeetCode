package interview.airbnb;

import utils.DataGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * Airbnb interview question.
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/23/17
 */
public class IntervalMaxSum {
    public int maxSum(int[][] dates, int maxDay) {
        return bruteForceWithMemorization(dates);
    }

    private int bruteForceWithMemorization(int[][] dates) {
        Map<String, Integer> memo = new HashMap<>();
        return sum(dates, new int[] {-1, -1}, 0, memo);
    }

    private int sum(int[][] dates, int[] prev, int pos, Map<String, Integer> memo) {
        String key = prev[0] + "-" + prev[1] + "-" + pos;
        if (memo.containsKey(key))
            return memo.get(key);
        if (pos == dates.length) return 0;
        int include = 0;
        if (prev[1] < dates[pos][0]) { // include;
            include = sum(dates, dates[pos], pos + 1, memo) + dates[pos][1] - dates[pos][0];
        }
        int notInclude = sum(dates, prev, pos + 1, memo);
        int max = Math.max(include, notInclude);
        memo.put(key, max);
        return max;
    }

    public static void main(String[] args) {
        IntervalMaxSum s = new IntervalMaxSum();

        System.out.println(s.maxSum(DataGenerator.createIntMatrix("1,2|3,5|4,7|10,20|15,30"), 30));
    }
}
