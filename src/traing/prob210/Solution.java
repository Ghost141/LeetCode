package traing.prob210;

import utils.DataGenerator;
import utils.PrintUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Course Schedule II
 * Link: https://leetcode.com/problems/course-schedule-ii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/21/17
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        for (int[] pair : prerequisites) {
            int ready = pair[0];
            int pre = pair[1];
            List<Integer> list = graph[pre];
            if (list == null) {
                list = new ArrayList<>();
                graph[pre] = list;
            }
            list.add(ready);
            indegree[ready]++;
        }
        int count = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) queue.offer(i);
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            List<Integer> adjacent = graph[vertex];
            res[count++] = vertex;
            if (adjacent == null) continue;
            for (Integer neighbor : adjacent)
                if (--indegree[neighbor] == 0) queue.offer(neighbor);
        }
        return count == numCourses ? res : new int[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        PrintUtils.printai(s.findOrder(2, DataGenerator.createIntMatrix("0,1|1,0")));
    }
}
