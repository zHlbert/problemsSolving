package contest.leetcode20210829;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You are given an array of strings nums and an integer k. Each string in nums represents an integer without leading zeros.
 *
 * Return the string that represents the kth largest integer in nums.
 *
 * Note: Duplicate numbers should be counted distinctly. For example, if nums is ["1","2","2"], "2" is the first largest integer, "2" is the second-largest integer, and "1" is the third-largest integer.
 */
public class FindTheKthLargestIntegerInTheArray {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return a.compareTo(b);
            }
        });

//        List<Integer> intNums = Arrays.stream(nums).map(Integer::parseInt).collect(Collectors.toList());
//        System.out.println(intNums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        FindTheKthLargestIntegerInTheArray f = new FindTheKthLargestIntegerInTheArray();
        String[] sdf = new String[] {"642","75","643","123","13","640","145","6342"};
        System.out.println(f.kthLargestNumber(sdf, 3));
    }
}
