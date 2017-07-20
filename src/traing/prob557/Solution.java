package traing.prob557;

/**
 * Reverse Words in a String III
 *
 * @author zhaokai
 */
public class Solution {
    public String reverseWords(String s) {
        String word = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(reverse(word)).append(" ");
                word = "";
            } else {
                word += s.charAt(i);
            }
        }
        if (!word.isEmpty()) {
            sb.append(reverse(word));
        }

        return sb.toString();
    }

    private String reverse(String s) {
        char[] data = new char[s.length()];
        int j= 0;
        for (int i = s.toCharArray().length - 1; i >= 0; i--) {
            data[j] = s.charAt(i);
            j++;
        }
        return String.valueOf(data);
    }


}
