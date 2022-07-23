package contest.leetcode20220723;

public class NumberOfZeroFilledSubarrays {
    public long zeroFilledSubarray(int[] nums) {
        boolean zeroFront = false;
        long res = 0;
        int zeroCnt = 0;
        for (int num : nums) {
            if (num != 0) {
                if (zeroFront) {
                    res += (long) (zeroCnt + 1) * zeroCnt / 2;
                    zeroFront = false;
                    zeroCnt = 0;
                }
                continue;
            }
            zeroCnt++;
            zeroFront = true;
        }
        if (zeroFront) {
            res += (long) (zeroCnt + 1) * zeroCnt / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfZeroFilledSubarrays nz = new NumberOfZeroFilledSubarrays();
//        int[] nums = new int[] {1,3,0,0,2,0,0,4};
        int[] nums = new int[] {2,10,2019};
        System.out.println(nz.zeroFilledSubarray(nums));
    }
}
