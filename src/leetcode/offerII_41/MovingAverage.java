package leetcode.offerII_41;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/qIsx9U/
 */
public class MovingAverage {
    Queue<Integer> queue;
    int sum, size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
        sum = 0;
    }

    public double next(int val) {
        if (queue.size() >= size) {
            int poll = queue.poll();
            sum -= poll;
        }
        sum += val;
        queue.offer(val);
        return (double) sum / queue.size();
    }
}
