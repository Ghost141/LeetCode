package traing.prob24;

import traing.common.ListNode;

/**
 * Swap Nodes in Pairs
 * Link: https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/12/17
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(-1), prev = fakeHead;
        fakeHead.next = head.next;

        while (head != null && head.next != null) {
            ListNode curr = head;
            ListNode next = head.next;
            head = head.next.next;
            curr.next = curr.next.next;
            next.next = curr;
            prev.next = next;
            prev = curr;
        }
        return fakeHead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
    }
}
