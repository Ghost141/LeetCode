package traing.prob388;

import java.util.ArrayList;
import java.util.List;

/**
 * Longest Absolute File Path
 * Link: https://leetcode.com/problems/longest-absolute-file-path/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/28/17
 */
public class Solution {
    public int lengthLongestPath(String input) {
        int subLength = 0, tabCount = 0, max = 0;
        boolean isFile = false;
        List<Integer> levelLength = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '\t') tabCount++;
            else if (c == '\n') {
                max = Math.max(max, calculate(levelLength, subLength, tabCount, isFile));
                tabCount = 0;
                subLength = 0;
                isFile = false;
            } else {
                if (c == '.') isFile = true;
                subLength++;
            }
        }
        return Math.max(max, calculate(levelLength, subLength, tabCount, isFile));
    }

    private int calculate(List<Integer> levelLength, int subLength, int tabCount, boolean isFile) {
        if (levelLength.size() <= tabCount) levelLength.add(subLength);
        else levelLength.set(tabCount, subLength);
        int sum = 0;

        if (isFile) { // Count and update max.
            for (int j = 0; j <= tabCount; j++) sum += levelLength.get(j);
            sum += tabCount;
        }
        System.out.println(levelLength);
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String input = "dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext";
//        System.out.println(s.lengthLongestPath(input));
//        System.out.println(s.lengthLongestPath("a\n\taa\n\t\taaa\n\t\t\tfile1.txt\naaaaaaaaaaaaaaaaaaaaa\n\tsth.png"));
        System.out.println(s.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}
