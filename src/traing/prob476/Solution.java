package traing.prob476;

public class Solution {
    public int findComplement(int num) {
        if (num == Integer.MAX_VALUE) {
            return 0;
        }

        int result = 0;
        int digit = 0;
        while (num != 0) {
            result += ((num & 1) ^ 1) << digit;
            digit++;
            num = num >>> 1;
        }

        return result;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println(s.findComplement(1));
    }
}
