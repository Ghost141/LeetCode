package traing.prob369;

import traing.common.ListNode;
import utils.DataGenerator;

/**
 * Plus One Linked List
 * Link: https://leetcode.com/problems/plus-one-linked-list/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/28/17
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode lastNot9 = new ListNode(0), ret = lastNot9, h = head;
        lastNot9.next = head;

        while (head != null) {
            if (head.val != 9) lastNot9 = head;

            head = head.next;
        }
        if (lastNot9 != ret) ret = h;

        lastNot9.val += 1;
        lastNot9 = lastNot9.next;
        while (lastNot9 != null) {
            lastNot9.val = 0;
            lastNot9 = lastNot9.next;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.plusOne(DataGenerator.buildListNode("1-9")));
        System.out.println(s.plusOne(DataGenerator.buildListNode("1-8")));
        System.out.println(s.plusOne(DataGenerator.buildListNode("9-9")));
    }
}
