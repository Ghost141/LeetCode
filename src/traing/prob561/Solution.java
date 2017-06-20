package traing.prob561;

import java.util.Arrays;

public class Solution {
    public int arrayPairSum(int[] sums) {
        Arrays.sort(sums);

        int result = 0;
        for (int i = 0; i < sums.length / 2; i++) {
            result += sums[i * 2];
        }

        return result;
    }
}
