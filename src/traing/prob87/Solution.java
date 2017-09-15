package traing.prob87;

import java.util.HashMap;
import java.util.Map;

/**
 * Scramble String
 * Link: https://leetcode.com/problems/scramble-string/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/14/17
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
//        return recursive(s1, s2, new HashMap<>());
        return dpBottomUp(s1, s2);
    }

    private boolean recursive(String s1, String s2, Map<String, Boolean> map) {
        int i = 0, len = s1.length();
        boolean res = false;
        if (s1.length() != s2.length()) return false;
        if (len == 0) return true;
        else if (len == 1) return s1.equals(s2);
        else {
            if (map.containsKey(s1 + s2)) return map.get(s1 + s2);
            if (s1.equals(s2)) return true;
            else {
                for (i = 1; i < len && !res; i++) {
                    res = res || (recursive(s1.substring(0, i), s2.substring(0, i), map) && recursive(s1.substring(i), s2.substring(i), map));
                    res = res || (recursive(s1.substring(0, i), s2.substring(i), map) && recursive(s1.substring(i), s2.substring(0, i), map));
                }
                map.put(s1 + s2, res);
                return res;
            }
        }
    }

    private boolean dpBottomUp(String s1, String s2) {
        int l1 = s1.length();
        if (l1 == 0) return true;
        if (l1 == 1) return s1.equals(s2);
        boolean[][][] isScram = new boolean[l1 + 1][l1][l1];

        for (int i = 0; i < l1; i++)
            for (int j = 0; j < l1; j++)
                isScram[1][i][j] = s1.charAt(i) == s2.charAt(j);

        for (int len = 2; len <= l1; len++) {
            for (int i = 0; i <= l1 - len; i++) {
                for (int j = 0; j <= l1 - len; j++) {
                    isScram[len][i][j] = false;
                    for (int k = 1; k < len && !isScram[len][i][j]; k++) {
                        isScram[len][i][j] = isScram[len][i][j] || (isScram[k][i][j] && isScram[len - k][i + k][j + k]);
                        isScram[len][i][j] = isScram[len][i][j] || (isScram[k][i + len - k][j] && isScram[len - k][i][j + k]);
                    }
                }
            }
        }
        return isScram[l1][0][0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println("abc".substring(0, "abc".length() / 2));
//        System.out.println("abcd".substring(0, "abcd".length() / 2));
//        System.out.println("great".substring(0, "great".length() / 2));
//        System.out.println("great".substring("great".length() / 2));

//        System.out.println(s.isScramble("great", "rgtae"));
        System.out.println(System.currentTimeMillis());
        System.out.println(s.isScramble("bcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcde",
                "cebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebd"));
        System.out.println(System.currentTimeMillis());
    }
}
