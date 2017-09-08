package traing.common;

/**
 * The common Relation class.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/8/17
 */
public class Relation {
    private boolean[][] relationMatrix;
    public Relation(boolean[][] matrix) {
        relationMatrix = matrix;
    }

    public boolean knows(int a, int b) {
        return relationMatrix[a][b];
    }
}
