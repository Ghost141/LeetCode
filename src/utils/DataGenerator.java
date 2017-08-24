package utils;

import traing.ListNode;

/**
 * Test data generator
 *
 * @author zhaokai
 * @version 1.0
 * @version 1.1 - Add ListNode builder.
 * @since 1.0 - 8/17/17
 */
public class DataGenerator {
    private static DataGenerator ourInstance = new DataGenerator();

    public static DataGenerator getInstance() {
        return ourInstance;
    }

    private DataGenerator() {
    }

    public static int[] createIntArray(String s) {
        String[] split = s.split(",");
        int[] res = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            res[i] = Integer.valueOf(split[i].trim());
        }
        return res;
    }

    public static int[][] createIntMatrix(String s) {
        if (s.trim().equals("")) return new int[][]{};
        String[] rows = s.split("\\|");
        int[][] matrix = new int[rows.length][rows[0].split(",").length];
        for (int i = 0; i < rows.length; i++) {
            String row = rows[i];
            String[] cols = row.split(",");
            int[] intRow = new int[cols.length];
            for (int j = 0; j < cols.length; j++) {
                intRow[j] = Integer.valueOf(cols[j]);
            }
            matrix[i] = intRow;
        }
        return matrix;
    }

    public static ListNode buildListNode(String s) {
        String[] nodes = s.split("-");
        if (nodes.length == 0) return null;
        ListNode fakeHead = new ListNode(-1);
        ListNode head = new ListNode(Integer.valueOf(nodes[0].trim()));
        fakeHead.next = head;

        for (int i = 1; i < nodes.length; i++) {
            ListNode n = new ListNode(Integer.valueOf(nodes[i].trim()));
            head.next = n;
            head = n;
        }
        return fakeHead.next;
    }
}
