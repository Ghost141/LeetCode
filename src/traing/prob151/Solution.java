package traing.prob151;

public class Solution {
    public String reverseWords(String s) {
        String word = "";
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == ' ') {
                if (word.length() > 0) {
                    if (result.length() > 0) {
                        word = word + " ";
                    }
                    result = word + result;
                    word = "";
                }
            } else {
                word += c;
            }
        }

        if (word.length() > 0) {
            if (result.length() > 0) {
                word = word + " ";
            }
            result = word + result;
        }

        return result;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println("|" + s.reverseWords(" ") + "|");
        System.out.println("|" + s.reverseWords("a") + "|");
        System.out.println("|" + s.reverseWords("a ") + "|");
    }
}
