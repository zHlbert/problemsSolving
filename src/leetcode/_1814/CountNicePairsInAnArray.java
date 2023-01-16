package leetcode._1814;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairsInAnArray {
    int mod = (int) (1e9 + 7);

    /**
     * 哈希
     * @param nums
     * @return
     */
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        int[] rv = new int[n];
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            int diff = num - rev(num);
            cnt.put(diff, cnt.getOrDefault(diff, 0) + 1);
        }

        long res = 0;
        for (int c : cnt.values())
            res = (res + (long) c * (c - 1) / 2) % mod;
        return (int) res;
    }

    private int rev(int num) {
        int x = num, rv = 0;
        while (x != 0) {
            rv = rv * 10 + x % 10;
            x /= 10;
        }
        return rv;
    }

    public static void main(String[] args) {
        CountNicePairsInAnArray cn = new CountNicePairsInAnArray();
        System.out.println(cn.rev(25));
        System.out.println(cn.rev(145));
        System.out.println(cn.rev(330));
        System.out.println(cn.rev(4287000));
        System.out.println(cn.rev(0));
        System.out.println(cn.rev(5));
    }
}
