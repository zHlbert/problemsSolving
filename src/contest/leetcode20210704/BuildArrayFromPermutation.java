package contest.leetcode20210704;

/**
 * Given a zero-based permutation nums (0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
 *
 * A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
 */
public class BuildArrayFromPermutation {
    public int[] buildArray(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }

    public static void main(String[] args) {
        BuildArrayFromPermutation b = new BuildArrayFromPermutation();
        int[] nums = new int[] {0,2,1,5,3,4};
        int[] res = b.buildArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(res[i]);
        }
    }
}
