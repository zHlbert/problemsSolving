package leetcode._416;

/**
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        // dp[j] 表示： 容量为j的背包，所背的物品价值可以最⼤为dp[j]
        // dp[i]中的i表示背包内总和
        // 题目中说：每个数组中的元素不会超过 100，数组的⼤⼩不会超过 200
        // 总和不会⼤于20000，背包最⼤只需要其中⼀半，所以10001⼤⼩就可以了
        int[] dp = new int[10001];
        dp[0] = 0;
        // 01背包
        for (int num : nums) {
            // 每⼀个元素⼀定是不可重复放⼊，所以从大到小遍历
            for (int j = target; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[target] == target;
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        int[] nums = new int[] {1,5,11,5};
        System.out.println(p.canPartition(nums));
    }
}
