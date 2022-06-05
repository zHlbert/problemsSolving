package leetcode._732;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.cn/problems/my-calendar-iii/
 */
public class MyCalendarIII {

}

class MyCalendarThree {

    Map<Integer, Integer> map;
    public MyCalendarThree() {
        // 按key排序
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        // 差分数组
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;
        int res = 0;
        for (int value : map.values()) {
            count += value;
            // 找到有重叠的区间最大值
            res = Math.max(res, count);
        }
        return res;
    }
}
