package contest.leetcode20220806;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountNumberOfBadPairs {
//    public long countBadPairs(int[] nums) {
//        int n = nums.length;
//        long res = 0;
//        for (int i = 1, j = 0; i < n; i++) {
//            while (j < i && nums[j] - nums[i] != j - i) {
//                res += (i - j);
//                j++;
//            }
//        }
////        long total = (long) n * (n - 1) / 2;
////        return total - res;
//        return res;
//    }

    public long countBadPairs(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = nums[i] - i;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : diff) {
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        long res = (long) n * (n - 1) / 2;
        for (Integer cnt : map.values()) {
            if (cnt > 1) {
                res -= (long) (cnt - 1) * cnt / 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountNumberOfBadPairs cn = new CountNumberOfBadPairs();
//        int[] nums = new int[] {4,1,3,3};
        int[] nums = new int[] {1,2,3,4,5};
        System.out.println(cn.countBadPairs(nums));
    }
}
