package leetcode._961;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
 */
public class NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return 0;
    }

    /**
     * 如果相邻的 xx 之间至少都隔了 22 个位置，那么数组的总长度至少为
     * n+2(n−1)=3n−2
     * 当 n > 2 时，3n-2 > 2n，不存在满足要求的数组。因此一定存在两个相邻的 x，它们的位置是连续的，或者只隔了 1 个位置。
     *
     * 当 n = 2 时，数组的长度最多为 2n = 4，因此最多只能隔 2 个位置
     *
     *
     * @param nums
     * @return
     */
    public int repeatedNTimesMath(int[] nums) {
        int len = nums.length;
        if (len == 4) {
            if (nums[0] == nums[1] || nums[0] == nums[2] || nums[0] == nums[3]) {
                return nums[0];
            }
            if (nums[1] == nums[2] || nums[1] == nums[3]) {
                return nums[1];
            }
            return nums[2];
        }
        for (int i = 0; i < len - 2; i++) {
            if (nums[i + 1] == nums[i] || nums[i + 2] == nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }
}
