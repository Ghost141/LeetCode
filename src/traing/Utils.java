package traing;

import java.util.Arrays;
import java.util.StringJoiner;

public final class Utils {

    private Utils() {}

    public static void printai(int[] input) {
        final StringJoiner joiner = new StringJoiner(", ");
        for (int i : input) {
            joiner.add(String.valueOf(i));
        }
        System.out.println("result: [" + joiner.toString() + "].");

    }

    public static void printIntMatrix(int[][] matrix) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append("[");
            final StringJoiner joiner = new StringJoiner(", ");
            for (int j = 0; j < matrix[0].length; j++) {
                joiner.add(String.valueOf(matrix[i][j]));
            }
            sb.append(joiner.toString());
            sb.append("]\n");
        }
        System.out.println(sb.toString());
    }

    public static void matrix(int[][] matrix, int[]... points) {
        char c = 'a';
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append("[");
            final StringJoiner joiner = new StringJoiner(", ");
            for (int j = 0; j < matrix[0].length; j++) {
                boolean special = false;
                for (int[] point : points) {
                    if (i == point[0] && j == point[1]) {
                        joiner.add(String.valueOf(c++));
                        special = true;
                        break;
                    }
                }
                if (!special) joiner.add(String.valueOf(matrix[i][j]));
            }
            sb.append(joiner.toString());
            sb.append("]\n");
        }
        System.out.println(sb.toString());
    }

    public static void printStrArr(String[] input) {
        final StringJoiner joiner = new StringJoiner(", ");
        for (String i : input) {
            joiner.add(i);
        }
        System.out.println("result: [" + joiner.toString() + "].");
    }

    public static <T> void printArray(T[] data) {
        final StringJoiner joiner = new StringJoiner(", ");
        for (T i : data) {
            joiner.add(String.valueOf(i));
        }
        System.out.println("result: [" + joiner.toString() + "].");
    }
}
