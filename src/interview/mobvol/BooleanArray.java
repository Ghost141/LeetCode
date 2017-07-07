package interview.mobvol;

public class BooleanArray {
    int[] data = new int[] {};
    int offset = 0;
    public boolean get(int index) {

        final int offset1 = index / 32;
        final int offset2 = index % 32;

        if (offset1 > data.length) {
            System.err.println("Error");
            return false;
        } else {
            final int value = data[offset1];
            return shift(value, offset2) == 1;
        }
    }

    public void add(boolean a) {

    }

    private int shift(int value, int length) {
        int res = 0;
        while (length > 0) {
            res = value >>> 1;
            length --;
        }
        return res;
    }
}
