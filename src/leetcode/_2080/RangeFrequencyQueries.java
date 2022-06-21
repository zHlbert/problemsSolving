package leetcode._2080;

import java.util.ArrayList;
import java.util.List;


public class RangeFrequencyQueries {

    public static void main(String[] args) {
        RangeFreqQuery rfq = new RangeFreqQuery(new int[] {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
        System.out.println(rfq.query(1,2,4));
        System.out.println(rfq.query(0,11,33));
        System.out.println(rfq.query(0,8,33));
        System.out.println(rfq.query(0,7,33));
        System.out.println(rfq.query(1,7,33));
        System.out.println(rfq.query(1,6,33));
        System.out.println(rfq.query(2,7,33));
        System.out.println(rfq.query(2,6,33));
        System.out.println(rfq.query(3,6,33));
    }
}

class RangeFreqQuery {
    List<Integer>[] occr = new ArrayList[10001];

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < occr.length; i++) {
            occr[i] = new ArrayList<>();
        }

        for (int i = 0; i < arr.length; i++) {
            occr[arr[i]].add(i);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> indices = occr[value];
        if (indices.isEmpty()) {
            return 0;
        }
        // 第一个大于等于 left 的下标
        int leftIndex = lowerBound(indices, left);
        // 第一个大于 right 的下标
        int rightIndex = upperBound(indices, right);
        return rightIndex - leftIndex;
    }

    private int upperBound(List<Integer> indices, int val) {
        int l = 0, r = indices.size() - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (indices.get(mid) <= val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return indices.get(l) > val ? l : indices.size();
    }

    private int lowerBound(List<Integer> indices, int val) {
        int l = 0, r = indices.size() - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (indices.get(mid) < val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return indices.get(l) >= val ? l : indices.size();
    }

    private int myBinarySearch(List<Integer> indices, int value) {
        int left = 0, right = indices.size() - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (indices.get(mid) == value) {
                left = mid;
                break;
            } else if (indices.get(mid) < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return indices.get(left) <= value ? left : - 1;
    }
}
