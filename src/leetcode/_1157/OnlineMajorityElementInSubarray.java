package leetcode._1157;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnlineMajorityElementInSubarray {
    public static void main(String[] args) {
        MajorityChecker mc = new MajorityChecker(new int[] {1,1,1,1,2,2});
        System.out.println(mc.query(0,5,4));
        System.out.println(mc.query(0,3,3));
        System.out.println(mc.query(2,3,2));
//        List<Integer> nums = List.of(1,1,1,1,2,2);
//        System.out.println(mc.binarySearch1(nums, 3));
//        System.out.println(mc.binarySearch1(nums, 2));
//        System.out.println(mc.binarySearch1(nums, 1));
    }
}

/**
 * https://leetcode.cn/problems/online-majority-element-in-subarray/solution/by-424479543-8wxq/
 */
class MajorityChecker {
    int[][] bitArr;
    int n, m = 16;
    Map<Integer, List<Integer>> map = new HashMap<>();

    public MajorityChecker(int[] arr) {
        n = arr.length;
        bitArr = new int[n + 1][m];
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], a -> new ArrayList<>()).add(i);
            for (int j = 0; j < m; j++) {
                bitArr[i + 1][j] = bitArr[i][j] + (arr[i] >> j & 1);
            }
        }
    }

    public int query(int left, int right, int threshold) {
        int res = 0;
        for (int i = 0; i < m; i++) {
            int a = bitArr[right + 1][i] - bitArr[left][i];
            int b = right - left + 1 - a;
            if (a >= threshold) res |= 1 << i;
            else if (b < threshold) return -1;
        }
        if (!map.containsKey(res)) return -1;
        List<Integer> list = map.get(res);
        int c = binarySearch(list, right) - binarySearch1(list, left);
        return c >= threshold ? res : -1;
    }

    public int binarySearch(List<Integer> nums, int t) { // 找到小于等于t的最大下标
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (nums.get(mid) <= t) left = mid;
            else right = mid - 1;
        }
        return nums.get(left) <= t ? left : -1;
    }

    public int binarySearch1(List<Integer> nums, int t) { // 找到小于t的最大下标
//        System.out.println(nums + ", " + t);
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (nums.get(mid) < t) left = mid;
            else right = mid - 1;
        }
//        System.out.println(left);
        return nums.get(left) < t ? left : -1;
    }


}
