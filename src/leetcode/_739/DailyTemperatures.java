package leetcode._739;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        // 单调栈 保存数组下标
        Deque<Integer> deque = new ArrayDeque<>(n);
        deque.push(0);
        for (int i = 1; i < n; i++) {
            int t = temperatures[i];
            // 保持栈顶到栈底是递增的
            while (!deque.isEmpty() && t > temperatures[deque.peek()]) {
                int top = deque.pop();
                result[top] = i - top;
            }
            deque.push(i);
        }
        return result;
    }
}
