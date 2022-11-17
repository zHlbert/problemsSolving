package leetcode._891;

import java.util.Arrays;

/**
 * 子序列宽度之和
 * https://leetcode.cn/problems/sum-of-subsequence-widths/
 */
public class SumOfSubsequenceWidths {
    int mod = (int) (1e9 + 7);

    /**
     * 排序 数学 贡献值
     * @param nums
     * @return
     */
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, pw = 1;
        long res = 0;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            res = (res + ((long) ((nums[i] - nums[j]) % mod) * pw) % mod) % mod;
            pw = (pw << 1) % mod;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        SumOfSubsequenceWidths ss = new SumOfSubsequenceWidths();
        System.out.println(ss.sumSubseqWidths(new int[] {6,8,3,5,1,5,7,3,4}));
    }
}
