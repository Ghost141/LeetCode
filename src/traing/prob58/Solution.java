package traing.prob58;

/**
 * Length of Last Word
 * Link: https://leetcode.com/problems/length-of-last-word/description/
 *
 * @author zhaokai
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        String word = "";
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                length = word.length() > 0 ? word.length() : length;
                word = "";
            } else {
                word += s.charAt(i);
            }
        }

        return word.length() > 0 ? word.length() : length;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();
        System.out.println(s.lengthOfLastWord("   "));
        System.out.println(s.lengthOfLastWord(""));
        System.out.println(s.lengthOfLastWord(" "));
        System.out.println(s.lengthOfLastWord("a"));
        System.out.println(s.lengthOfLastWord("ab"));
        System.out.println(s.lengthOfLastWord("ab "));
        System.out.println(s.lengthOfLastWord(" ab "));
        System.out.println(s.lengthOfLastWord(" ab"));
        System.out.println(s.lengthOfLastWord(" ab werwerwer"));
        System.out.println(s.lengthOfLastWord(" ab werwerwer  "));
    }
}
