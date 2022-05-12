package leetcode._216;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode.cn/problems/combination-sum-iii/
 */
public class CombinationSumIII {
    List<List<Integer>> res = new ArrayList<>();
    int k;
    int n;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        backtrack(1, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int startIndex, int sum, List<Integer> list) {
        if (list.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        // 剪枝，如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了
        for (int j = startIndex; j < 10 - (k - list.size()) + 1; j++) {
            list.add(j);
            backtrack(j + 1, sum + j, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII cs = new CombinationSumIII();
        int k = 3;
        int n = 24;
        System.out.println(cs.combinationSum3(k, n));
    }
}
