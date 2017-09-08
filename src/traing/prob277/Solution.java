package traing.prob277;

import traing.common.Relation;
import utils.DataGenerator;

/**
 * Find the Celebrity
 * Link: https://leetcode.com/problems/find-the-celebrity/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/8/17
 */
public class Solution extends Relation {

    public Solution(boolean[][] matrix) {
        super(matrix);
    }

    public int findCelebrity(int n) {
        int can = 0;
        for (int i = 0; i < n; i++)
            if (knows(can, i)) can = i;
        for (int i = 0; i < n; i++)
            if (i != can && (!knows(i, can) || knows(can, i))) return -1;
        return can;
    }

    public static void main(String[] args) {
        Solution s = new Solution(DataGenerator.createBooleanMatrix("t,t|f,t"));


        System.out.println(s.findCelebrity(2));
    }
}
