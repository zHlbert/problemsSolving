package leetcode._565;

/**
 * https://leetcode.cn/problems/array-nesting/
 */
public class ArrayNesting {
    boolean[] visited;
    int maxL = 0;

    public int arrayNesting(int[] nums) {
        int n = nums.length;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(nums, i, 0);
            }
        }
        return maxL;
    }

    private void dfs(int[] nums, int i, int c) {
        if (visited[nums[i]]) {
            maxL = Math.max(maxL, c);
            return;
        }
        visited[nums[i]] = true;
        dfs(nums, nums[i], c + 1);
    }

    public static void main(String[] args) {
        ArrayNesting an = new ArrayNesting();
        int[] nums = new int[] {5,4,0,3,1,6,2};
//        int[] nums = new int[] {0,1,2};
        System.out.println(an.arrayNesting(nums));
    }
}
