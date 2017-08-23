package traing.prob567;

/**
 * Permutation in String
 * Link: https://leetcode.com/problems/permutation-in-string/description/
 *
 * @author zhaokai
 * @version 1.1 - Sliding window solution.
 * @since 1.0 - 8/23/17
 */
public class Solution {
    public boolean checkInclusion(String perm, String str) {
        return slidingWindow(perm, str);
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

    private boolean slidingWindow(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] c1 = new int[26], c2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (isMatches(c1, c2)) return true;
            c2[s2.charAt(i) - 'a']--;
            c2[s2.charAt(i + s1.length()) - 'a']++;
        }
        return isMatches(c1, c2);
    }

    private boolean isMatches(int[] c1, int[] c2) {
        for (int i = 0; i < c1.length; i++)
            if (c1[i] != c2[i]) return false;
        return true;
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
