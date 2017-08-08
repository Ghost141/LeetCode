package traing.prob19;

import traing.ListNode;

/**
 * Remove Nth Node From End of List
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/8/17
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode secondPointer = fakeHead, firstPointer = fakeHead;
        for (int i = 0; i <= n; i++) {
            secondPointer = secondPointer.next;
        }

        while (secondPointer != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }
        firstPointer.next = firstPointer.next.next;

        return fakeHead.next;
    }
}
