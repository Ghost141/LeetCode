package traing.prob146;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache
 * Link: https://leetcode.com/problems/lru-cache/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/18/17
 */
public class LRUCache {
    private int capacity;
    private int count = 0;
    private Map<Integer, DoubleLinkedNode> cache = new HashMap<>();
    private DoubleLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        DoubleLinkedNode node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DoubleLinkedNode node = cache.get(key);
            moveToHead(node);
            node.value = value;
        } else {
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            addNode(newNode);
            cache.put(key, newNode);
            count++;
            if (count > capacity) {
                DoubleLinkedNode nodeToDel = popTail();
                removeNode(nodeToDel);
                cache.remove(nodeToDel.key);
                count--;
            }
        }
    }

    class DoubleLinkedNode {
        int key;
        int value;
        DoubleLinkedNode prev = null, next = null;

        public DoubleLinkedNode() {
        }

        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void addNode(DoubleLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkedNode node) {
        DoubleLinkedNode prev = node.prev;
        DoubleLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DoubleLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private DoubleLinkedNode popTail() {
        DoubleLinkedNode res = tail.prev;
        this.removeNode(res);
        return res;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
