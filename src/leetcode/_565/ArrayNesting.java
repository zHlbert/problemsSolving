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

    /**
     * 循环
     * @param nums
     * @return
     */
    public int arrayNesting1(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int maxL = 0;
        for (int i = 0; i < n; i++) {
            int c = 0;
            if (!visited[i]) {
                int index = nums[i];
                while (!visited[index]) {
                    visited[index] = true;
                    c++;
                    index = nums[index];
                }
            }
            maxL = Math.max(maxL, c);
        }
        return maxL;
    }

    /**
     * 循环 修改原数组
     * @param nums
     * @return
     */
    public int arrayNesting2(int[] nums) {
        int n = nums.length;
        int maxL = 0;
        for (int i = 0; i < n; i++) {
            int c = 0;
            if (nums[i] != -1) {
                int index = nums[i];
                while (nums[index] != -1) {
                    c++;
                    int next = nums[index];
                    nums[index] = -1;
                    index = next;
                }
                maxL = Math.max(maxL, c);
            }
        }
        return maxL;
    }

    public static void main(String[] args) {
        ArrayNesting an = new ArrayNesting();
        int[] nums = new int[] {5,4,0,3,1,6,2};
//        int[] nums = new int[] {0,1,2};
        System.out.println(an.arrayNesting1(nums));
    }
}
