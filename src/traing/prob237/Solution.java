package traing.prob237;

import traing.common.ListNode;

public class Solution {
    public void deleteNode(ListNode node) {
        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
