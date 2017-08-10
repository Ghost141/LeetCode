package traing.prob551;

/**
 * Student Attendance Record I
 * Link: https://leetcode.com/problems/student-attendance-record-i/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/10/17
 */
public class Solution {
    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) return false;
        int aCount = 0, continuousLCount = 0;
        char c, prev = ' ';
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == 'A') {
                aCount++;
            } else if (c == 'L') {
                if (prev == 'L') {
                    continuousLCount++;
                } else {
                    continuousLCount = 1;
                }
            }

            if (continuousLCount == 3 || aCount == 2) return false;
            prev = c;
        }

        return true;
    }
}
