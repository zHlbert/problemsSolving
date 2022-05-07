package contest.leetcode2022031301;

/**
 * You are given a 0-indexed integer array nums representing the contents of a pile, where nums[0] is the topmost element of the pile.
 *
 * In one move, you can perform either of the following:
 *
 * If the pile is not empty, remove the topmost element of the pile.
 * If there are one or more removed elements, add any one of them back onto the pile. This element becomes the new topmost element.
 * You are also given an integer k, which denotes the total number of moves to be made.
 *
 * Return the maximum value of the topmost element of the pile possible after exactly k moves. In case it is not possible to obtain a non-empty pile after k moves, return -1.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-the-topmost-element-after-k-moves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximizeTheTopmostElementAfterKMoves {
    public int maximumTop(int[] nums, int k) {
        if (k == 0) {
            return nums[0];
        }
        if (nums.length == 1 && k % 2 == 1) {
            return -1;
        }
        int maxInK = k >= nums.length ? -1 : nums[k];
        int maxInPre = -1;
        for (int i = 0; i < Math.min(k - 1, nums.length); i++) {
            if (nums[i] > maxInPre) {
                maxInPre = nums[i];
            }
        }
        return Math.max(maxInK, maxInPre);
    }

    public static void main(String[] args) {
        MaximizeTheTopmostElementAfterKMoves m = new MaximizeTheTopmostElementAfterKMoves();
        int[] nums = new int[] {18};
        int k = 4;
        System.out.println(m.maximumTop(nums, k));
    }
}
