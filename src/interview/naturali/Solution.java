package interview.naturali;

import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Solution for problem 1
     * @param words
     * @return
     */
    public String reverseWords(String words) {
        String result = "";
        String word = "";
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (c == ' ') {
                result = word + " " + result;
                word = "";
            } else {
                word = word + c;
            }
        }

        if (word.length() > 0) {
            result = word + " " + result;
        }

        return result;
    }

    /**
     * Solution for problem 2. Failed to find a solution.
     * @param data
     * @return
     */
    public Integer minimumDifference(List<Integer> data) {
        Integer sum = 0;
        Integer diff = 0;
        for (Integer i : data) {
            sum += i;
        }
        double average = sum / 2;



        return 0;
    }

    /**
     * Solution for problem 3.
     * @param points
     * @return
     */
    public int[] findNode(int[][] points) {
        int n = points.length;
        int x = 0, y = 0, minSum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int[] currentPoint = new int[] {i, j};
                if (!inPoints(points, new int[]{i, j})) {
                    for (int[] p: points) {
                        sum += calculateLength(p, currentPoint);
                    }

                    if (sum < minSum) {
                        minSum = sum;
                        x = i; y = j;
                    }
                }
            }
        }

        return new int[] {x, y};
    }

    private int calculateLength(int[] pointA, int[] pointB) {
        return Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
    }

    private boolean inPoints(int[][] points, int[] point) {
        for (int i = 0; i < points.length; i++) {
            int xi = points[i][0], xj = points[i][1];
            if (xi == point[0] && xj == point[1]) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.reverseWords("Hello world"));
        System.out.println(s.reverseWords("Hello"));
        System.out.println(s.reverseWords("a b d e"));

        System.out.println(Arrays.toString(s.findNode(new int[][]{{0, 0}, {2, 2}})));
    }
}
