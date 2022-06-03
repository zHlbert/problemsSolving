package leetcode._1509;

import java.util.Arrays;

/**
 * You are given an integer array nums. In one move, you can choose one element of nums and change it by any value.
 *
 * Return the minimum difference between the largest and smallest value of nums after performing at most three moves.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode.cn/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public int minDifferenceSort(int[] nums) {
        int n = nums.length;
        if (n < 5) {
            return 0;
        }
        Arrays.sort(nums);
        int l = 0, r = n - 1;
        return Math.min(
                        Math.min(nums[r] - nums[l + 3], nums[r - 1] - nums[l + 2])
                        , Math.min(nums[r - 2] - nums[l + 1], nums[r - 3] - nums[l]));
    }

    /**
     * 一次遍历找到最大和最小的四个数
     * @param nums
     * @return
     */
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n < 5) {
            return 0;
        }
        // 最大/最小的4个元素
        int[] max4 = new int[4], min4 = new int[4];
        Arrays.fill(max4, Integer.MIN_VALUE);
        Arrays.fill(min4, Integer.MAX_VALUE);
        for (int num : nums) {
            int idx = 0;
            // max4中元素比当前数大时，增加下标
            while (idx < 4 && max4[idx] > num) {
                idx++;
            }
            // 比当前数大的不到4个
            if (idx < 4) {
                // 依次后移，留出位置
                for (int i = 3; i >= idx + 1; i--) {
                    max4[i] = max4[i - 1];
                }
                max4[idx] = num;
            }
            idx = 0;
            while (idx < 4 && min4[idx] < num) {
                idx++;
            }
            if (idx < 4) {
                for (int i = 3; i >= idx + 1; i--) {
                    min4[i] = min4[i - 1];
                }
                min4[idx] = num;
            }
        }
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            minDiff = Math.min(minDiff, max4[i] - min4[3 - i]);
        }
        return minDiff;
    }

    public static void main(String[] args) {
        MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves md = new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves();
//        int[] nums = new int[] {5,3,2,4};
//        int[] nums = new int[] {1,5,0,10,14};
        int[] nums = new int[] {6,6,0,1,1,4,6};
        System.out.println(md.minDifferenceSort(nums));
    }
}
