package leetcode._895;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/maximum-frequency-stack/
 * 最大频率栈
 */
public class MaximumFrequencyStack {

}

/**
 * 栈 哈希表
 */
class FreqStack {
    int m = 20005;
    // 相应频数的数栈
    Deque<Integer>[] stks;
    Map<Integer, Integer> freq;
    int maxFreq;

    public FreqStack() {
        stks = new Deque[m];
        for (int i = 0; i < m; i++) {
            stks[i] = new ArrayDeque<>();
        }
        freq = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        stks[freq.get(val)].push(val);
        maxFreq = Math.max(maxFreq, freq.get(val));
    }

    public int pop() {
        int val = stks[maxFreq].pop();
        freq.put(val, freq.get(val) - 1);
        if (stks[maxFreq].isEmpty()) {
            maxFreq--;
        }
        return val;
    }
}
