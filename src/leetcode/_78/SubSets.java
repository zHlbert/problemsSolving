package leetcode._78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubSets {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> subset = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            backtracking(nums, i + 1);
            subset.removeLast();
        }
    }

    public static void main(String[] args) {
        SubSets s = new SubSets();
        int[] nums = new int[] {1,2,3};
        System.out.println(s.subsets(nums));
    }
}
