package leetcode._2420;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-good-indices/
 */
public class FindAllGoodIndices {
    /**
     * 动态规划 DP
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] lr = new int[n], rl = new int[n];
        Arrays.fill(lr, 1);
        Arrays.fill(rl, 1);
        for (int i = 1; i < n - k; i++) {
            if (nums[i] <= nums[i - 1]) {
                lr[i] = lr[i - 1] + 1;
            }
            if (nums[n - i - 1] <= nums[n - i]) {
                rl[n - i - 1] = rl[n - i] + 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = k; i < n - k; i++) {
            if (lr[i - 1] >= k && rl[i + 1] >= k) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllGoodIndices fag = new FindAllGoodIndices();
//        int[] nums = {2,1,1,1,3,4,1};
//        int k = 2;
//        [878724,201541,179099,98437,35765,327555,475851,598885,849470,943442]
//        4
        int[] nums = {878724,201541,179099,98437,35765,327555,475851,598885,849470,943442};
        int k = 4;
        System.out.println(fag.goodIndices(nums, k));
    }
}
