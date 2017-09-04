package traing.prob582;

import java.util.*;

/**
 * Kill Process
 * Link: https://leetcode.com/problems/kill-process/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/4/17
 */
public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> ppChildrenMap = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            List<Integer> list = ppChildrenMap.getOrDefault(ppid.get(i), new ArrayList<>());
            list.add(pid.get(i));
            ppChildrenMap.put(ppid.get(i), list);
        }
        List<Integer> res = new ArrayList<>();

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(kill);
        res.add(kill);
        while (!queue.isEmpty()) {
            Integer todo = queue.poll();
            List<Integer> children = ppChildrenMap.get(todo);
            if (children != null) {
                res.addAll(children);
                for (Integer child : children) {
                    queue.offer(child);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.killProcess(Arrays.asList(1,3,10,5), Arrays.asList(3,0,5,3), 5));
        System.out.println(s.killProcess(Arrays.asList(1,3,10,5), Arrays.asList(3,0,5,3), 3));
        System.out.println(s.killProcess(Arrays.asList(1,3,10,5), Arrays.asList(3,0,5,3), 10));
        System.out.println(s.killProcess(Arrays.asList(1,3,10,5), Arrays.asList(3,0,5,3), 1));
        System.out.println(s.killProcess(Arrays.asList(1,3,10,5), Arrays.asList(3,0,5,3), 0));
    }
}
