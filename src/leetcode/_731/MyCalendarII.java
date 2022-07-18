package leetcode._731;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarII {

}

class MyCalendarTwo {

    TreeMap<Integer, Integer> cnt;

    public MyCalendarTwo() {
        cnt = new TreeMap<>();
    }

    /**
     * 差分数组
     * @param start
     * @param end
     * @return
     */
    public boolean book(int start, int end) {
        int maxBook = 0;
        cnt.put(start, cnt.getOrDefault(start, 0) + 1);
        cnt.put(end, cnt.getOrDefault(end, 0) - 1);
        for (Integer value : cnt.values()) {
            maxBook += value;
            if (maxBook > 2) {
                cnt.put(start, cnt.get(start) - 1);
                cnt.put(end, cnt.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}