package traing.prob567;

/**
 * Permutation in String
 * Link: https://leetcode.com/problems/permutation-in-string/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/23/17
 */
public class Solution {
    public boolean checkInclusion(String perm, String str) {
        return backtrack("", perm, str, new boolean[perm.length()]);
    }

    private boolean backtrack(String tmp, String perm, String str, boolean[] used) {
        if (tmp.length() == perm.length()) return str.contains(tmp);
        for (int i = 0; i < perm.length(); i++) {
            if (used[i]) continue;
            tmp += perm.charAt(i);
            if (!str.contains(tmp)) {
                tmp = tmp.substring(0, tmp.length() - 1);
                continue;
            }
            used[i] = true;
            if (backtrack(tmp, perm, str, used)) {
                return true;
            }
            used[i] = false;
            tmp = tmp.substring(0, tmp.length() - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.checkInclusion("ab", "eibaooo"));
//        System.out.println(s.checkInclusion("ab", "eiabooo"));
//        System.out.println(s.checkInclusion("ab", "eiaabooo"));
//        System.out.println(s.checkInclusion("ab", "eiaabbooo"));
//        System.out.println(s.checkInclusion("ab", "eibooao"));
//        System.out.println(s.checkInclusion("ab", "a"));
        System.out.println(s.checkInclusion("adc", "dcda"));
    }
}
