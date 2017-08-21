package traing;

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
        final StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < matrix.length; i++) {

        }
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
