package traing.prob113;

import traing.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        return null;
    }

    private List<List<Integer>> pathSumFrom(TreeNode root, int sum) {
        if (root == null) {

        }
        return null;
    }

    private List<List<Integer>> merge(List<List<Integer>> l1, List<List<Integer>> l2) {
        List<List<Integer>> result = new ArrayList<>();
        Collections.addAll(l1);
        Collections.addAll(l2);
        result.addAll(l1);
        result.addAll(l2);
        return result;
    }
}
