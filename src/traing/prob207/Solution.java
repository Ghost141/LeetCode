package traing.prob207;

import utils.DataGenerator;

import java.util.*;

/**
 * Course Schedule
 * Link: https://leetcode.com/problems/course-schedule/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 9/21/17
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] matrix = new List[numCourses];
        int[] indegree = new int[numCourses];

        for (int[] pair : prerequisites) {
            int ready = pair[0];
            int pre = pair[1];
            List<Integer> list = matrix[pre];
            if (list == null) {
                list = new ArrayList<>();
                matrix[pre] = list;
            }
            list.add(ready);
            indegree[ready]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        // Enlist all output node.
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) queue.offer(i);

        int count = 0;
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            count++;
            List<Integer> adjacent = matrix[vertex];
            if (adjacent == null) continue;
            for (Integer neighbor : adjacent)
                if (--indegree[neighbor] == 0) queue.offer(neighbor);
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.canFinish(4, DataGenerator.createIntMatrix("1,0|2,1|3,2|1,3")));
    }
}
