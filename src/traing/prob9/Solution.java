package traing.prob9;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        return this.isPalindromeString(String.valueOf(x));
    }

    private boolean isPalindromeString(String s) {
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1);
        } else if (s.length() == 1) {
            return true;
        } else {
            return s.charAt(0) == s.charAt(s.length() - 1)
                    && this.isPalindromeString(s.substring(1, s.length() - 1));
        }
    }

    public static void main(String[] args) {
        final Solution s = new Solution();
        System.out.println(s.isPalindrome(123));
        System.out.println(s.isPalindrome(131));
        System.out.println(s.isPalindrome(1));
        System.out.println(s.isPalindrome(22));
        System.out.println(s.isPalindrome(456652));
    }
}
