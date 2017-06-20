package traing.prob504;

public class Solution {
    public String convertToBase7(int num) {
        String s = "";
        boolean neg = false;
        if (num == 0) {
            return "0";
        } else if (num < 0) {
            neg = true;
            num = -num;
        }
        while (num != 0) {
            s = num % 7 + s;
            num /= 7;
        }

        return neg ? "-" + s : s;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println(s.convertToBase7(-7));
    }
}
