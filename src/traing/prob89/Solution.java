package traing.prob89;

import java.util.ArrayList;
import java.util.List;

/**
 * Gray Code
 * Link: https://leetcode.com/problems/gray-code/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/7/17
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(5 ^ 2);
    }
}
