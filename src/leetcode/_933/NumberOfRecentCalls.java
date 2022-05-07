package leetcode._933;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 */
public class NumberOfRecentCalls {
    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
    }
}

class RecentCounter {
    Deque<Integer> deque;
    public RecentCounter() {
        deque = new LinkedList<>();
    }

    public int ping(int t) {
        deque.offerFirst(t);
        while (deque.peekLast() + 3000 < t) {
            deque.pollLast();
        }
        return deque.size();
    }
}
