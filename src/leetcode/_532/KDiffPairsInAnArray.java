package leetcode._532;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/k-diff-pairs-in-an-array/
 */
public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        Set<Integer> fromSet = new HashSet<>();
        for (int i = 0, j = 0; i < n; i++) {
            while (nums[i] - nums[j] > k) {
                j++;
            }
            if (!fromSet.contains(j) && i != j && nums[i] - nums[j] == k) {
                res++;
                fromSet.add(j);
            }
        }
        return res;
    }

    public int findPairsHash(int[] nums, int k) {
        Set<Integer> visited = new HashSet<>(), res = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }

    public static void main(String[] args) {
        KDiffPairsInAnArray kd = new KDiffPairsInAnArray();
        int[] nums = new int[] {3,1,4,1,5};
        int k = 2;
//        int[] nums = new int[] {1,2,3,4,5};
//        int k = 1;
//        int[] nums = new int[] {1,3,1,5,4};
//        int k = 0;
//        int[] nums = new int[] {1,1,1,3,3,3,4,5,6};
//        int k = 2;
//        int[] nums = new int[] {1,1,1,1,1};
//        int k = 0;
        System.out.println(kd.findPairsHash(nums, k));
    }
}
