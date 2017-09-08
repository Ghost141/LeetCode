package traing.prob406;

import utils.PrintUtils;
import utils.DataGenerator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Queue Reconstruction by Height
 * Link: https://leetcode.com/problems/queue-reconstruction-by-height/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/1/17
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int c1 = Integer.compare(o1[0], o2[0]);
                if (c1 == 0) return Integer.compare(o1[1], o2[1]);
                else return -c1;
            }
        });
        List<int[]> res = new LinkedList<>();

        for (int[] person : people) {
            res.add(person[1], person);
        }

        return res.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        PrintUtils.printIntMatrix(s.reconstructQueue(DataGenerator.createIntMatrix("7,0|4,4|7,1|5,0|6,1|5,2")));
    }
}
