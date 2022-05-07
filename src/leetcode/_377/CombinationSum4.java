package leetcode._377;

/**
 * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 *
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        // 完全背包
        int sum = 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        // (1,1,2) 与 (1,2,1) 不同，实际是排列个数，先循环背包重量（target）再循环物品（nums）
        for (int i = 0; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSum4 cs4 = new CombinationSum4();
        int[] nums = new int[] {1,2,3};
        int target = 4;
        System.out.println(cs4.combinationSum4(nums, target));
    }
}
