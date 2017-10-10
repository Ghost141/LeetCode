package traing.prob401;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Binary Watch
 * Link: https://leetcode.com/problems/binary-watch/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/10/17
 */
public class Solution {
    private static final int[] HOUR = {
            8, 4, 2, 1
    };

    private static final int[] MIN = {
            32, 16, 8, 4, 2, 1
    };

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        List<Integer> hours = new ArrayList<>();
        List<Integer> minutes = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            backtrack(hours, 0, HOUR, 0, 11, i);
            backtrack(minutes, 0, MIN, 0, 59, num - i);
            for (Integer hour : hours)
                for (Integer minute : minutes)
                    res.add(hour + ":" + (minute < 10 ? "0" : "") + minute);
            hours.clear();
            minutes.clear();
        }
        return res;
    }

    private void backtrack(List<Integer> res, int val, int[] nums, int start, int limit, int count) {
        if (count == 0) {
            if (val <= limit) res.add(val);
        } else {
            for (int i = start; i < nums.length; i++)
                backtrack(res, val + nums[i], nums, i + 1, limit, count - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = s.readBinaryWatch(2);
        Collections.sort(list);
        System.out.println(list);
    }
}
