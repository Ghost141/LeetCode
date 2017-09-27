package utils;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.function.Function;

public final class PrintUtils {

    private PrintUtils() {}

    public static void printai(int[] input) {
        intArrayPrinter("result").apply(input);
    }

    public static Function<int[], Void> intArrayPrinter(String name) {
        return (int[] input) -> {
            final StringJoiner joiner = new StringJoiner(", ");
            for (int i : input) {
                joiner.add(String.valueOf(i));
            }
            System.out.println(name + ": [" + joiner.toString() + "].");
            return null;
        };
    }

    public static void print3DIntArr(int[][][] input) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            sb.append("[");
            final StringJoiner joiner = new StringJoiner(", ");
            for (int j = 0; j < input[0].length; j++) {
                StringJoiner row = new StringJoiner(",");
                for (int k = 0; k < input[i][j].length; k++) row.add(String.valueOf(input[i][j][k]));
                joiner.add("(" + row.toString() + ")");
            }
            sb.append(joiner.toString());
            sb.append("]\n");
        }
        System.out.println(sb.toString());
    }

    public static void printCharArray(char[] input) {
        final StringJoiner joiner = new StringJoiner(", ");
        for (char i : input) {
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

    public static void printCharMatrix(char[][] matrix) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append("[");
            final StringJoiner joiner = new StringJoiner(", ");
            for (int j = 0; j < matrix[0].length; j++) {
                joiner.add(Character.toString(matrix[i][j]));
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
