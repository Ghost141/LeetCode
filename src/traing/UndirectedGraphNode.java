package traing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * The common undirected graph node.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/1/17
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int label) {
        this.label = label;
        this.neighbors = new ArrayList<>();
    }

    public UndirectedGraphNode(int label, UndirectedGraphNode... neigh) {
        this.label = label;
        this.neighbors = new ArrayList<>();
        Collections.addAll(this.neighbors, neigh);
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("{");
//        StringJoiner joiner = new StringJoiner("#");
//        joiner.add(this.toStr(null));
//        for (UndirectedGraphNode neighbor : neighbors) {
//            joiner.add(neighbor.toStr(this));
//        }
//
//        sb.append(joiner.toString());
//
//        sb.append("}");
//        return sb.toString();
//    }

    private String toStr(UndirectedGraphNode mainNode) {
        StringJoiner joiner = new StringJoiner(",");
        joiner.add(String.valueOf(this.label));

        if (this.neighbors.size() != 0) {
            for (UndirectedGraphNode neighbor : neighbors) {
                if (neighbor != mainNode) {
                    joiner.add(String.valueOf(neighbor.label));
                }
            }
        }

        return joiner.toString();
    }
}
