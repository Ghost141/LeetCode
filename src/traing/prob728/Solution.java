package traing.prob728;

import java.util.LinkedList;
import java.util.List;

/**
 * Self Dividing Numbers
 * Link: https://leetcode.com/problems/self-dividing-numbers/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/19/17
 */
public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int num = left; num <= right; num++) {
            int tmp = num;
            list.add(num);
            while (tmp != 0) {
                int digit = tmp % 10;
                if (digit == 0 || num % digit != 0) {
                    list.removeLast();
                    break;
                }
                tmp /= 10;
            }
        }
        return list;
    }
}
