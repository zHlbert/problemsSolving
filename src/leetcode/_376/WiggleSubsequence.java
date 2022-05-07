package leetcode._376;

/**
 * A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with one element and a sequence with two non-equal elements are trivially wiggle sequences.
 *
 * For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) alternate between positive and negative.
 * In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences. The first is not because its first two differences are positive, and the second is not because its last difference is zero.
 * A subsequence is obtained by deleting some elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.
 *
 * Given an integer array nums, return the length of the longest wiggle subsequence of nums.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int maxL = 1;
        int currL = 1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > 0 && i < len - 1 && !diffLabel(nums[i] - nums[i - 1], nums[i + 1] - nums[i])) {
                maxL = Math.max(maxL, currL);
                currL = 1;
            } else {
                currL++;
            }
        }
        maxL = Math.max(maxL, currL);
        return maxL;
    }

    public int wiggleMaxLength1(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        int[] diff = new int[len - 1];
        for (int i = 1; i < len; i++) {
            diff[i - 1] = nums[i] - nums[i - 1];
        }
        int maxL = 1;
        int currL = 1;
        for (int i = 1; i < len - 1; i++) {
            if (diffLabel(diff[i], diff[i - 1])) {
                currL++;
            } else {
                maxL = Math.max(maxL, currL);
                currL = 1;
            }
        }
        return maxL + 1;
    }

    private boolean diffLabel(int num1, int num2) {
        return num1 > 0 && num2 < 0 || num1 < 0 && num2 > 0;
    }

    public int wiggleMaxLength2(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        int preDiff = 0;
        int currDiff = 0;
        int res = 1;
        for (int i = 0; i < len - 1; i++) {
            currDiff = nums[i + 1] - nums[i];
            if (currDiff > 0 && preDiff <= 0 || currDiff < 0 && preDiff >= 0) {
                res++;
                preDiff = currDiff;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        WiggleSubsequence w = new WiggleSubsequence();
        int[] nums = new int[] {1,17,5,10,13,15,10,5,16,8};
        System.out.println(w.wiggleMaxLength2(nums));
    }
}
