package traing.prob686;

/**
 * Repeated String Match
 * Link: https://leetcode.com/problems/repeated-string-match/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/15/17
 */
public class Solution {
    public int repeatedStringMatch(String A, String B) {
        int k = 1;
        StringBuilder builder = new StringBuilder(A);
        for (; builder.length() < B.length(); k++) builder.append(A);
        if (builder.indexOf(B) >= 0) return k;
        else if (builder.append(A).indexOf(B) >= 0) return k + 1;
        return -1;
    }
}
