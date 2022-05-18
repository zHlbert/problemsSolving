package contest.leetcode20220327;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/contest/weekly-contest-286/problems/find-the-difference-of-two-arrays/
 */
public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        Set<Integer> tmpSet1 = new HashSet<>(set1);
        Set<Integer> tmpSet2 = new HashSet<>(set2);
        List<List<Integer>> res = new ArrayList<>();
        set1.removeAll(tmpSet2);
        List<Integer> res1 = new ArrayList<>(set1);
        set2.removeAll(tmpSet1);
        List<Integer> res2 = new ArrayList<>(set2);
        res.add(res1);
        res.add(res2);
        return res;
    }

    public static void main(String[] args) {
        FindTheDifferenceOfTwoArrays fd = new FindTheDifferenceOfTwoArrays();
        int[] nums1 = new int[] {1,2,3,3};
        int[] nums2 = new int[] {1,1,2,2};
//        int[] nums1 = new int[] {1,2,3};
//        int[] nums2 = new int[] {4,5,6};
        System.out.println(fd.findDifference(nums1, nums2));
    }
}
