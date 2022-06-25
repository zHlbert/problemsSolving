package contest.leetcode20220625;

import java.util.ArrayList;
import java.util.List;

public class MaximumXORAfterOperations {
    public int maximumXOR(int[] nums) {
        int n = nums.length;
        List<Integer> oneCnt = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                if (num == 0) {
                    continue;
                }
                cnt += (num >> i) & 1;
            }
            oneCnt.add(cnt);
        }
        System.out.println(oneCnt);
        int maxD = 31;
        for (; maxD >= 0; maxD--) {
            if (oneCnt.get(maxD) > 0) {
                break;
            }
        }

        for (int i = maxD; i >= 0; i--) {
            int cnt = oneCnt.get(i);
            if (cnt > 1 && n - cnt == cnt) {

            }
        }
        return 0;
    }

    public int maximumXOR1(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res |= num;
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumXORAfterOperations mx = new MaximumXORAfterOperations();
//        int[] nums = new int[] {3,2,4,6};
        int[] nums = new int[] {1,2,3,9,2};
        System.out.println(mx.maximumXOR1(nums));
    }
}
