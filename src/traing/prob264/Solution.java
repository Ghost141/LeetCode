package traing.prob264;

import java.util.ArrayList;
import java.util.List;


// TODO: Finish the DP code.
public class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> numbers = new ArrayList<>();
        if (n == 1) {
            return 1;
        }
        int count = 0;
        n -= 1;
//        int result = 1;
        int two = 1;
        int three = 1;
        int five = 1;
        while (count != n) {
            int result = 1;
            for (Integer number : numbers) {
                int tmp = number * result;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(5, 1690));
    }
}
