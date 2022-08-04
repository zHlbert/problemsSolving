package leetcode.interview1719;

/**
 * https://leetcode.cn/problems/missing-two-lcci/
 */
public class MissingTwoLCCI {
    /**
     * 加和
     * @param nums
     * @return
     */
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 缺失两数之和
        int twoSum = n * (n + 1) / 2 - sum;
        // 缺失两数 x + y 不相等，较小数 x <= (x + y) / 2 = part
        int part = twoSum / 2;
        sum = 0;
        for (int num : nums) {
            if (num <= part)
                sum += num;
        }
        // [1, part]中除了 x 以外所有数都出现在 nums 中
        int one = part * (part + 1) / 2 - sum;
        return new int[] {one, twoSum - one};
    }
}
