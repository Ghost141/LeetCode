package traing.prob722;

import java.util.ArrayList;
import java.util.List;

/**
 * Remove Comments
 * Link:
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/5/17
 */
public class Solution {
    public List<String> removeComments(String[] source) {
        boolean inComment = false;
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (String line : source) {
            int ind = 0;
            while (ind != line.length()) {
                if (inComment) {
                    int c = line.indexOf("*/", ind);
                    if (c >= 0) {
                        ind = c + 2;
                        inComment = false;
                    } else ind = line.length();
                } else {
                    int c1 = line.indexOf("//", ind);
                    int c2 = line.indexOf("/*", ind);
                    if (c1 < 0 && c2 < 0) {
                        builder.append(line.substring(ind));
                        ind = line.length();
                    } else {
                        if (min(c1, c2) == c1) {
                            builder.append(line.substring(ind, c1));
                            ind = line.length();
                        } else {
                            builder.append(line.substring(ind, c2));
                            inComment = true;
                            ind = c2 + 2;
                        }
                    }
                }
            }
            if (builder.length() > 0 && !inComment) {
                res.add(builder.toString());
                builder = new StringBuilder();
            }
        }
        return res;
    }
    private int min(int a, int b) {
        if (a < 0) return b;
        else if (b < 0) return a;
        else return Math.min(a, b);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.removeComments(new String[] {"/*Test program */",
                "int main()",
                "{ ",
                "  // variable declaration ",
                "int a\nb\nc;",
        "/* This is a test",
        "   multiline  ",
        "   comment for ",
        "   testing */",
        "a = b + c;",
        "}"}));
    }
}
