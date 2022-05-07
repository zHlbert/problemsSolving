package leetcode._560;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int pre = 0;
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0, 1);
        int count = 0;
        for (int num : nums) {
            pre += num;
            if (sumCountMap.containsKey(pre - k)) {
                count += sumCountMap.get(pre - k);
            }
            sumCountMap.put(pre, sumCountMap.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK sse = new SubarraySumEqualsK();
        int[] nums = new int[] {1,2,3};
        int k = 3;
        System.out.println(sse.subarraySum(nums, k));
    }
}
