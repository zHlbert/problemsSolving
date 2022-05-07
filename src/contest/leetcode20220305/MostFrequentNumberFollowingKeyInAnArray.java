package contest.leetcode20220305;

/**
 * 给你一个下标从 0 开始的整数数组 nums ，同时给你一个整数 key ，它在 nums 出现过。
 *
 * 统计 在 nums 数组中紧跟着 key 后面出现的不同整数 target 的出现次数。换言之，target 的出现次数为满足以下条件的 i 的数目：
 *
 * 0 <= i <= n - 2
 * nums[i] == key 且
 * nums[i + 1] == target 。
 * 请你返回出现 最多 次数的 target 。测试数据保证出现次数最多的 target 是唯一的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-frequent-number-following-key-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MostFrequentNumberFollowingKeyInAnArray {
    public int mostFrequent(int[] nums, int key) {
        int[] freq = new int[1005];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != key) {
                continue;
            }
            int target = nums[i + 1];
            int j = i + 1;
            while (j < nums.length && target == nums[j]) {
                j++;
            }
            freq[target] = freq[target] + j - i - 1;
        }
        int maxF = 0;
        int maxTarget = -1;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxF) {
                maxF = freq[i];
                maxTarget = i;
            }
        }
        return maxTarget;
    }
}
