package contest.leetcode20220501;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/contest/weekly-contest-291/problems/k-divisible-elements-subarrays/
 */
public class KDivisibleElementsSubarrays {
    public int countDistinct(int[] nums, int k, int p) {
        Set<List<Integer>> subArrSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            List<Integer> arr = new ArrayList<>();
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % p == 0) {
                    cnt++;
                }
                if (cnt > k) {
                    break;
                }
                arr.add(nums[j]);
                subArrSet.add(new ArrayList<>(arr));
            }
        }
        System.out.println(subArrSet);
        return subArrSet.size();
    }

    public static void main(String[] args) {
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(1);
//        list2.add(2);
//        System.out.println(list1.equals(list2));
        KDivisibleElementsSubarrays kd = new KDivisibleElementsSubarrays();
        int[] nums = new int[] {2,3,3,2,2};
        int k = 2;
        int p = 2;
        System.out.println(kd.countDistinct(nums, k, p));
    }
}
