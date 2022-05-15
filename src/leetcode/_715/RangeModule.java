package leetcode._715;

import java.util.*;

/**
 * https://leetcode.cn/problems/range-module/
 */
public class RangeModule {
    TreeSet<Interval> ranges;
    public RangeModule() {
        ranges = new TreeSet<>();
    }

    public void addRange(int left, int right) {
        Iterator<Interval> it = ranges.tailSet(new Interval(0, left - 1)).iterator();
        while (it.hasNext()) {
            Interval iv = it.next();
            if (right < iv.left) {
                break;
            }
            left = Math.min(left, iv.left);
            right = Math.max(right, iv.right);
            it.remove();
        }
        ranges.add(new Interval(left, right));
    }

    public boolean queryRange(int left, int right) {
        Interval iv = ranges.higher(new Interval(0, left));
        return iv != null && iv.left <= left && iv.right >= right;
    }

    public void removeRange(int left, int right) {
        SortedSet<Interval> intervals = ranges.tailSet(new Interval(0, left));
        Iterator<Interval> it = intervals.iterator();
        List<Interval> res = new ArrayList<>();
        while (it.hasNext()) {
            Interval iv = it.next();
            if (right < iv.left) {
                break;
            }
            if (iv.left < left) {
                res.add(new Interval(iv.left, left));
            }
            if (right < iv.right) {
                res.add(new Interval(right, iv.right));
            }
            it.remove();
        }

        ranges.addAll(res);
    }

    public static void main(String[] args) {
        RangeModule rm = new RangeModule();
        rm.addRange(2,3);
        rm.addRange(5,8);
        System.out.println(rm.queryRange(5,9));
        rm.removeRange(6,7);
        System.out.println(rm.queryRange(7,8));
    }
}
