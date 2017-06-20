package traing.prob344;

public class Solution {
    public String reverseString(String s) {
        final int length = s.length();
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            char tmp = s.charAt(i);
            chars[i] = s.charAt(length - i - 1);
            chars[length - i - 1] = tmp;
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        final Solution s = new Solution();
        System.out.println(s.reverseString("hello"));
        System.out.println(s.reverseString("hey"));
    }
}
