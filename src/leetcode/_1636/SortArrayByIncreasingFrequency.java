package leetcode._1636;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        int[] cnt = new int[205];
        for (int num : nums) {
            cnt[num + 100]++;
        }
        int n = nums.length;
        Integer[] tmp = new Integer[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = nums[i];
        }
        Arrays.sort(tmp, (a, b) -> {
            if (cnt[a + 100] == cnt[b + 100]) {
                return b - a;
            }
            return cnt[a + 100] - cnt[b + 100];
        });
        for (int i = 0; i < n; i++) {
            nums[i] = tmp[i];
        }
        return nums;
    }

    public int[] frequencySort1(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        int n = nums.length;
        Integer[] tmp = new Integer[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = nums[i];
        }
        Arrays.sort(tmp, (a, b) -> cnt.get(a).equals(cnt.get(b)) ? b - a : cnt.get(a) - cnt.get(b));
        for (int i = 0; i < n; i++) {
            nums[i] = tmp[i];
        }
        return nums;
    }
}
