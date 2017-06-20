package traing.prob190;

/**
 * AC
 */
public class Solution {
    public int reverseBits(int n) {

        int result = 0;
        int count = 32;
        while (count != 0) {
            result = (result << 1 ) + (n & 1);
            n = n >>> 1;
            count --;
        }

        return result;
    }

    public static void main(String[] args) {
        final Solution s = new Solution();
//        System.out.println(s.reverseBits(43261596));
        System.out.println(s.reverseBits(Integer.MAX_VALUE + 1));
    }
}
