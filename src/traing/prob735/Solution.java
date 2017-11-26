package traing.prob735;

import utils.DataGenerator;
import utils.PrintUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Asteroid Collision
 * Link: https://leetcode.com/problems/asteroid-collision/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/26/17
 */
public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty()) {
                stack.push(asteroid);
            } else {
                collision(stack, asteroid);
            }
        }
        int[] res = new int[stack.size()];
        int ind = stack.size() - 1;
        while (!stack.isEmpty()) res[ind--] = stack.pop();
        return res;
    }

    private void collision(Deque<Integer> stack, int asteroid) {
        while (!stack.isEmpty()) {
            Integer top = stack.pop();
            if (willNotCollision(top, asteroid)) {
                stack.push(top);
                stack.push(asteroid);
                return;
            } else {
                if (Math.abs(top) == Math.abs(asteroid)) {
                    return;
                } else if (Math.abs(top) > Math.abs(asteroid)) {
                    stack.push(top);
                    return;
                } else if (stack.isEmpty()) {
                    stack.push(asteroid);
                    return;
                }
            }
        }

    }

    private boolean willNotCollision(int a, int b) {
        return (a > 0 && b > 0) || (a < 0 && b < 0) || (a < 0 && b > 0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        PrintUtils.printai(s.asteroidCollision(DataGenerator.createIntArray("5, 10, -5")));
//        PrintUtils.printai(s.asteroidCollision(DataGenerator.createIntArray("8,-8")));
//        PrintUtils.printai(s.asteroidCollision(DataGenerator.createIntArray("10,2,-5")));
//        PrintUtils.printai(s.asteroidCollision(DataGenerator.createIntArray("-2,-2,-2,1")));
        PrintUtils.printai(s.asteroidCollision(DataGenerator.createIntArray("1,-2,-2,-2")));
    }
}
