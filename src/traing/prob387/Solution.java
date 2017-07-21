package traing.prob387;

/**
 * First Unique Character in a String
 *
 * @author zhaokai
 */
public class Solution {
    public int firstUniqChar(String s) {
        int[] charList = new int[26];

        for (int i = 0; i < s.length(); i++) {
            final int c = s.charAt(i) - 'a';
            if (charList[c] == 0) {
                charList[c] = i + 1;
            } else if (charList[c] > 0) {
                charList[c] = -1;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i : charList) {
            if (i > 0) {
                min = Math.min(min, i);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min - 1;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println(s.firstUniqChar("abc"));
        System.out.println(s.firstUniqChar("leetcode"));
        System.out.println(s.firstUniqChar("loveleetcode"));
        System.out.println(s.firstUniqChar("aa"));
    }
}
