package traing.prob83;

import traing.common.ListNode;
import utils.DataGenerator;

/**
 * Remove Duplicates from Sorted List
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/24/17
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        ListNode prev = null;
        fakeHead.next = head;
        while (head != null) {
            if (prev == null) prev = head;
            else {
                if (head.val == prev.val) {
                    prev.next = head.next;
                } else {
                    prev = head;
                }
            }
            head = head.next;
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.deleteDuplicates(DataGenerator.buildListNode("1-1-2")));
        System.out.println(s.deleteDuplicates(DataGenerator.buildListNode("1-3-2")));
        System.out.println(s.deleteDuplicates(DataGenerator.buildListNode("1-1")));
        System.out.println(s.deleteDuplicates(DataGenerator.buildListNode("1-1-2-3-3")));
    }
}
