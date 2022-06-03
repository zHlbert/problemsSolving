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
    public int minDifference(int[] nums) {
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

    public static void main(String[] args) {
        MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves md = new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves();
//        int[] nums = new int[] {5,3,2,4};
//        int[] nums = new int[] {1,5,0,10,14};
        int[] nums = new int[] {6,6,0,1,1,4,6};
        System.out.println(md.minDifference(nums));
    }
}
