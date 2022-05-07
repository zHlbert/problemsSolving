package leetcode._40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSumII {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> combination = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIndex, int sum) {
        if (target == sum) {
            res.add(new ArrayList<>(combination));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            // 不同分支有相同元素则跳过
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.push(candidates[i]);
            backtracking(candidates, target, i + 1, sum + candidates[i]);
            combination.pop();
        }
    }

    public static void main(String[] args) {
        CombinationSumII c = new CombinationSumII();
        int[] nums = new int[] {10,1,2,7,6,1,5};
        System.out.println(c.combinationSum2(nums, 8));
    }
}
