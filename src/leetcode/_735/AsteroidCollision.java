package leetcode._735;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/asteroid-collision/
 */
public class AsteroidCollision {
    /**
     * 双端队列（栈）模拟
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int a : asteroids) {
            if (a > 0 || deque.isEmpty() || deque.peek() < 0) {
                deque.push(a);
            } else {
                while (!deque.isEmpty() && deque.peek() > 0 && deque.peek() < -a) {
                    deque.pop();
                }
                if (deque.isEmpty()) {
                    deque.push(a);
                    continue;
                }
                int top = deque.peek();
                if (top < 0) {
                    deque.push(a);
                    continue;
                }
                if (top == -a) {
                    deque.pop();
                }
            }
        }

        int n = deque.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = deque.pollLast();
        }
        return res;
    }

    /**
     * 栈模拟，简化判断
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision1(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int a : asteroids) {
            // a 是否存活
            boolean alive = true;
            while (alive && a < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -a;
                if (stack.peek() <= -a) {
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(a);
            }
        }
        int n = stack.size();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
