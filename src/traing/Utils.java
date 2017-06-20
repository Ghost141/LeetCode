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
}
