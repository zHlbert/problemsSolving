package contest.leetcode20220717;

import java.util.*;

public class MaxSumOfAPairWithEqualSumOfDigits {
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> digitSumMap = new HashMap<>();
        for (int num : nums) {
            int digitSum = getDigitSum(num);
            PriorityQueue<Integer> queue = digitSumMap.getOrDefault(digitSum, new PriorityQueue<>((a, b) -> (b - a)));
            queue.add(num);
            digitSumMap.put(digitSum, queue);
        }

        int maxSum = -1;
        for (PriorityQueue<Integer> queue : digitSumMap.values()) {
            if (queue.size() < 2) {
                continue;
            }
            int n1 = queue.poll();
            int n2 = queue.poll();
            maxSum = Math.max(maxSum, n1 + n2);
        }
        return maxSum;
    }

    private int getDigitSum(int num) {
        int res = 0;
        int n = num;
        while (n > 0) {
            res += n % 10;
            n = n / 10;
        }
        return res;
    }

    public int maximumSum1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;
        for (int num : nums) {
            int digitSum = getDigitSum(num);
            if (map.containsKey(digitSum)) {
                res = Math.max(res, map.get(digitSum) + num);
            }
            map.put(digitSum, Math.max(map.getOrDefault(digitSum, 0), num));
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSumOfAPairWithEqualSumOfDigits mnp = new MaxSumOfAPairWithEqualSumOfDigits();
        int[] nums = new int[] {4,6,10,6};
        System.out.println(mnp.maximumSum(nums));
    }
}
