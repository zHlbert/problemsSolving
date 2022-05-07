package leetcode._1004;

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        for (int i = 0, j = 0, count = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
            while (j <= i && count > k) {
                if (nums[j] == 0) {
                    count--;
                }
                j++;

            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII mco = new MaxConsecutiveOnesIII();
        int[] nums = new int[] {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(mco.longestOnes(nums, k));
    }
}
