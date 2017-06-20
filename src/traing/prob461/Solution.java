package traing.prob461;

public class Solution {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;

        while (xor > 0) {
            count += xor % 2;
            xor /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();
        System.out.println(s.hammingDistance(1, 4));
        System.out.println(s.hammingDistance(1, 7));
    }
}
