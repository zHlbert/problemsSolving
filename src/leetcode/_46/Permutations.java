package leetcode._46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    private void backtrack(int n, List<Integer> output, List<List<Integer>> res, int i) {
        // 所有数都填完了
        if (i == n) {
            res.add(new ArrayList<>(output));
        }
        for (int j = i; j < n; j++) {
            // 动态维护数组
            Collections.swap(output, i, j);
            // 继续递归填下一个数
            backtrack(n, output, res, i + 1);
            // 撤销操作
            Collections.swap(output, i, j);
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        List<List<Integer>> res = p.permute(new int[] {1,2,3});
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
