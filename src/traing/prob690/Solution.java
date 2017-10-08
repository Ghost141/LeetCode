package traing.prob690;

import traing.common.Employee;

import java.util.*;

/**
 * Employee Importance
 * Link: https://leetcode.com/problems/employee-importance/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/8/17
 */
public class Solution {
    public int getImportance(List<Employee> employees, int id) {

        Deque<Integer> queue = new ArrayDeque<>();
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) map.put(employee.id, employee);
        if (!map.containsKey(id)) return 0;
        for (Integer eId : map.get(id).subordinates) queue.offer(eId);
        int importance = map.get(id).importance;
        while (!queue.isEmpty()) {
            Integer eId = queue.poll();
            Employee emp = map.get(eId);
            importance += emp.importance;
            for (Integer subId : emp.subordinates) queue.offer(subId);
        }
        return importance;
    }
}
