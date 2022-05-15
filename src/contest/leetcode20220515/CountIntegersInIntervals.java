package contest.leetcode20220515;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-293/problems/count-integers-in-intervals/
 */
public class CountIntegersInIntervals {

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
