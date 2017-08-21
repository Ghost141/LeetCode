package traing.prob138;

import traing.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Copy List with Random Pointer
 * Link: https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/21/17
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode node = head, copy, fakeHead = new RandomListNode(-1);
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        copy = new RandomListNode(node.label);
        fakeHead.next = copy;

        while (node != null) {
            if (node.next != null && !map.containsKey(node.next))
                map.put(node.next, new RandomListNode(node.next.label));
            if (node.random != null && !map.containsKey(node.random))
                map.put(node.random, new RandomListNode(node.random.label));

            if (map.containsKey(node.next)) copy.next = map.get(node.next);
            if (map.containsKey(node.random)) copy.random = map.get(node.random);


            node = node.next;
            copy = copy.next;
        }
        return fakeHead.next;
    }

    public static void main(String[] args) {
//        Map<Integer, RandomListNode> map = new HashMap<>();
//
//        RandomListNode r3 = new RandomListNode(3);
//        RandomListNode r2 = new RandomListNode(2);
//        RandomListNode r1 = new RandomListNode(1, null, r2);
//        map.put(1, r1);
//        map.put(2, r2);
//        for (Map.Entry<Integer, RandomListNode> entry : map.entrySet()) {
//            System.out.println(entry.getValue());
//        }
//
//        System.out.println("-----------------------------------------");
//        map.get(2).random = r3;
//
//        for (Map.Entry<Integer, RandomListNode> entry : map.entrySet()) {
//            System.out.println(entry.getValue());
//        }
//
//        System.out.println("=========================");
//        System.out.println(r1);
//        System.out.println(r2);
//        System.out.println(r3);

        Solution s = new Solution();

        System.out.println(s.copyRandomList(new RandomListNode(-1, new RandomListNode(-1), null)));
    }
}
