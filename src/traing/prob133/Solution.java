package traing.prob133;

import traing.UndirectedGraphNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Clone Graph
 * Link: https://leetcode.com/problems/clone-graph/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/1/17
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Deque<UndirectedGraphNode> queue = new ArrayDeque<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode o = queue.poll();
            UndirectedGraphNode copy = map.getOrDefault(o, new UndirectedGraphNode(o.label));

            map.put(o, copy);
            for (UndirectedGraphNode neighbor : o.neighbors) {
                if (map.containsKey(neighbor)) {
                    copy.neighbors.add(map.get(neighbor));
                } else {
                    UndirectedGraphNode neiCopy = new UndirectedGraphNode(neighbor.label);
                    queue.offer(neighbor);
                    map.put(neighbor, neiCopy);
                    copy.neighbors.add(neiCopy);
                }
            }
        }
        return map.get(node);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        UndirectedGraphNode n0 = new UndirectedGraphNode(0);
        UndirectedGraphNode n1 = new UndirectedGraphNode(1);
        UndirectedGraphNode n2 = new UndirectedGraphNode(2);
        n2.neighbors.add(n2);
        n1.neighbors.add(n0);
        n1.neighbors.add(n2);
        n0.neighbors.add(n1);
        n0.neighbors.add(n2);

//        System.out.println(s.cloneGraph(n0));
        UndirectedGraphNode z1 = new UndirectedGraphNode(0);
//        UndirectedGraphNode z2 = new UndirectedGraphNode(0);
//        UndirectedGraphNode z3 = new UndirectedGraphNode(0);
        z1.neighbors.add(z1);
//        z1.neighbors.add(z1);
        System.out.println(z1);
        UndirectedGraphNode z1Copy = s.cloneGraph(z1);
        System.out.println(z1Copy);
    }

}
