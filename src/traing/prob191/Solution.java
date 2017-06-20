package traing.prob191;

public class Solution {
    public int hammingWeight(int x) {
        int count = 0;
        while (x != 0) {
            count += x & 1;
            x = x>>>1;
        }

        return count;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println(s.hammingWeight(Integer.MAX_VALUE + 1));
    }
}
