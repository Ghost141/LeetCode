package traing.prob654;

import traing.TreeNode;
import utils.DataGenerator;

/**
 * Maximum Binary Tree
 * Link: https://leetcode.com/problems/maximum-binary-tree/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/1/17
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null;
        int max, left = start, right = end;
        while (left != right) {
            if (nums[left] > nums[right]) {
                right--;
            } else {
                left++;
            }
        }
        max = left;
        TreeNode root = new TreeNode(nums[max]);
        root.left = build(nums, start, max - 1);
        root.right = build(nums, max + 1, end);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode node = s.constructMaximumBinaryTree(DataGenerator.createIntArray("3,2,1,6,0,5"));
        System.out.println(node);
        System.out.println(s.constructMaximumBinaryTree(new int[] {}));
        System.out.println(s.constructMaximumBinaryTree(new int[] {1}));
    }
}
