package leetcode._962;

public class TriplesWithBitwiseANDEqualToZero {
    public int countTriplets(int[] nums) {
        int[] cnt = new int[1 << 16];
        for (int x : nums)
            for (int y : nums)
                cnt[x & y]++;

        int res = 0;
        for (int z : nums)
            for (int mask = 0; mask < 1 << 16; mask++)
                if ((z & mask) == 0)
                    res += cnt[mask];

        return res;
    }
}
