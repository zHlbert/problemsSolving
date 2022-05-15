package contest.leetcode20220515;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.cn/contest/weekly-contest-293/problems/count-integers-in-intervals/
 */
public class CountIntegersInIntervals {
    public static void main(String[] args) {
        CountIntervals ci = new CountIntervals();
        ci.add(1,6);
        ci.add(9,13);
        ci.add(15,18);
        ci.add(19,23);
        ci.add(26,30);
        ci.add(8,20);
        System.out.println(ci.count());
    }
}

class CountIntervals {
    // 当前所有区间的总合
    int sum;
    // key为左端点值
    TreeMap<Integer, int[]> map;
    public CountIntervals() {
        sum = 0;
        map = new TreeMap<>();
    }

    public void add(int left, int right) {
        // 类似向下取整 找到map中 左端点 小于等于right的 左端点最大的区间
        Map.Entry<Integer, int[]> l = map.floorEntry(right);
        // 新形成的左右端点
        int lt = left;
        int rt = right;
        // 若该区间右端点 大于等于 要加入的左端点 即两区间有重叠
        while (l != null && l.getValue()[1] >= lt) {
            sum -= l.getValue()[1] - l.getValue()[0] + 1;
            lt = Math.min(lt, l.getValue()[0]);
            rt = Math.max(rt, l.getValue()[1]);
            map.remove(l.getKey());
            l = map.floorEntry(right);
        }
        // 添加最终算出的新区间
        map.put(lt, new int[] {lt, rt});
        sum += rt - lt + 1;
    }

    public int count() {
        return sum;
    }
}

//class CountIntervals {
//
//    List<int[]> intervals;
//
//    public CountIntervals() {
//        intervals = new ArrayList<>();
//    }
//
//    public void add(int left, int right) {
//        if (intervals.isEmpty()) {
//            intervals.add(new int[] {left, right});
//        } else {
//            int idxLeft = findIdx(left, 0);
//            int idxRight = findIdx(right, 1);
//            int size = intervals.size();
//            if (idxLeft == size && idxRight == size) {
//                intervals.add(new int[] {left, right});
//            } else if (idxLeft == -1 && idxRight == -1) {
//                intervals.add(0, new int[] {left, right});
//            } else if (idxLeft == -1 && idxRight == size) {
//                intervals.clear();
//                intervals.add(new int[] {left, right});
//            } else if (idxRight == size) {
//
//            }
////            if (left > intervals.get(idxRight)[1]) {
////                intervals.add(new int[] {left, right});
////            } else if (left == intervals.get(idxRight)[1]) {
////                intervals.get(idxRight)[1] = right;
////            } else if ()
//        }
//    }
//
//    private int findIdx(int val, int lr) {
//        if (intervals.isEmpty()) {
//            return -2;
//        }
//        int[] last = intervals.get(intervals.size() - 1);
//        if (val > last[lr]) {
//            return intervals.size();
//        } else if (val == last[lr]) {
//            return intervals.size() - 1;
//        }
//
//        int[] first = intervals.get(0);
//        if (val < first[lr]) {
//            return -1;
//        } else if (val == first[lr]) {
//            return 0;
//        }
//        int l = 0, r = intervals.size() - 1;
//        while (l < r) {
//            int mid = (l + r) >> 1;
//            if (intervals.get(mid)[lr] == val) {
//                return mid;
//            } else if (intervals.get(mid)[lr] > val) {
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return l;
//    }
//
//    public int count() {
//
//    }
//}
