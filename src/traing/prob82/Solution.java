package traing.prob82;

import traing.ListNode;
import utils.DataGenerator;

/**
 * Remove Duplicates from Sorted List II
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/24/17
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(-1);
        ListNode prev = fakeHead;
        fakeHead.next = head;
        head = head.next;
        while (head != null) {
            if (prev.next.val == head.val) {
                while (head != null && prev.next.val == head.val)
                    head = head.next;
                prev.next = head;
                if (head == null) break;
            } else {
                prev = prev.next;
            }

            head = head.next;
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.deleteDuplicates(DataGenerator.buildListNode("1-2-3-3")));
        System.out.println(s.deleteDuplicates(DataGenerator.buildListNode("1-2-2-3")));
        System.out.println(s.deleteDuplicates(DataGenerator.buildListNode("1-1-2-2-3")));
    }
}
