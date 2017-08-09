package traing.prob390;

import java.util.ArrayList;
import java.util.List;

/**
 * Elimination Game
 * Link: https://leetcode.com/problems/elimination-game/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/9/17
 */
public class Solution {
    public int lastRemaining(int n) {
        List<Integer> data = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            data.add(i);
        }
        boolean left = true;
        while (data.size() != 1) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                if (left && i % 2 == 1) {
                    tmp.add(data.get(i));
                } else if (!left && (data.size() - i) % 2 == 0) {
                    tmp.add(data.get(i));
                }
            }
            left = !left;
            data = tmp;
        }

        return data.get(0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.lastRemaining(6));
        System.out.println(s.lastRemaining(9));
    }
}
