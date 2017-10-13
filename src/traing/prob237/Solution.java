package traing.prob237;

import traing.common.ListNode;

/**
 * Delete Node in a Linked List
 * Link: https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/15/17
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
