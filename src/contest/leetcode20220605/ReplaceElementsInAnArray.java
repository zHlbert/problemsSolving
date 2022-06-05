package contest.leetcode20220605;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ReplaceElementsInAnArray {
//    public int[] arrayChange(int[] nums, int[][] operations) {
//        int n = nums.length;
//        Integer[] idx = new Integer[n];
//        for (int i = 0; i < n; i++) {
//            idx[i] = i;
//        }
//
//        Arrays.sort(idx, Comparator.comparing(i -> nums[i]));
////        int[] nums0 = new int[n];
////        for (int i = 0; i < n; i++) {
////            nums0[i] = nums[i];
////        }
//
//        for (int[] operation : operations) {
//
//            int targetNum = operation[0];
//            int left = 0, right = n - 1;
//            int targetIdx = -1;
//            while (left <= right) {
//                int mid = (left + right) >> 1;
//                int curNum = nums[idx[mid]];
//                if (curNum == targetNum) {
//                    targetIdx = idx[mid];
//                    break;
//                } else if (curNum > targetNum) {
//                    right = mid - 1;
//                } else {
//                    left = mid + 1;
//                }
//            }
//            nums[targetIdx] = operation[1];
//
//            Arrays.sort(idx, Comparator.comparing(i -> nums[i]));
//        }
//        return nums;
//    }

    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int[] op : operations) {
            int idx = map.get(op[0]);
            nums[idx] = op[1];
            map.put(op[1], idx);
        }
        return nums;
    }

    public static void main(String[] args) {
        ReplaceElementsInAnArray re = new ReplaceElementsInAnArray();
        int[] nums = new int[] {1,2,4,6};
        int[][] op = new int[][] {{1,3},{4,7},{6,1}};
//        int[] nums = new int[] {1,2};
//        int[][] op = new int[][] {{1,3},{2,1},{3,2}};
        ArrayUtils.printArray(re.arrayChange(nums, op));
    }
}
