package leetcode._47;

import java.util.*;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class PermutationsII {
    boolean[] visited;
    List<List<Integer>> res;
    Deque<Integer> path;
    int n;
    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        visited = new boolean[n];
        res = new ArrayList<>();
        path = new LinkedList<>();
        Arrays.sort(nums);
        backtracking(nums);
        return res;
    }

    private void backtracking(int[] nums) {
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                path.addLast(nums[i]);
                backtracking(nums);
                path.removeLast();
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        PermutationsII p = new PermutationsII();
        int[] nums = new int[] {1,1,2};
        System.out.println(p.permuteUnique(nums));
    }
}
