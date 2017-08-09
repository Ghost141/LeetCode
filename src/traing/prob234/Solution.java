package traing.prob234;

import traing.ListNode;

import java.util.Stack;

/**
 * Palindrome Linked List
 * Link: https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 8/10/17
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (slow.next != null) {
            slow = slow.next;
        }

        Stack<ListNode> stack = new Stack<>();

        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        while (!stack.empty()) {
            if (head.val != stack.pop().val) return false;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(s.isPalindrome(head));
    }
}
