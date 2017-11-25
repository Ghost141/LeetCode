package traing.prob630;

import utils.DataGenerator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Course Schedule III
 * Link: https://leetcode.com/problems/course-schedule-iii/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/24/17
 */
public class Solution {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        int time = 0;
        for (int[] course : courses) {
            int duration = course[0];
            int endTime = course[1];
            if (duration + time <= endTime) {
                time += duration;
                queue.offer(duration);
            } else if (!queue.isEmpty() && queue.peek() > duration) {
                time -= queue.poll() - duration;
                queue.offer(duration);
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.scheduleCourse(DataGenerator.createIntMatrix("100,200|200,1300|1000,1250|2000,3200"))); // 3
//        System.out.println(s.scheduleCourse(DataGenerator.createIntMatrix("1,2|2,3"))); // 2
//        System.out.println(s.scheduleCourse(DataGenerator.createIntMatrix("5,15|3,19|6,7|2,10|5,16|8,14|10,11|2,19"))); // 5
        System.out.println(s.scheduleCourse(DataGenerator.createIntMatrix("7,17|3,12|10,20|9,10|5,20|10,19|4,18"))); // 4
    }
}
