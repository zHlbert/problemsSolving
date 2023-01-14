package leetcode._1819;

/**
 * 序列中不同最大公约数的数目
 * https://leetcode.cn/problems/number-of-different-subsequences-gcds/
 */
public class NumberOfDifferentSubsequencesGCDs {
    /**
     * https://leetcode.cn/problems/number-of-different-subsequences-gcds/solution/xu-lie-zhong-bu-tong-zui-da-gong-yue-shu-ha1j/
     * 枚举 数学
     * @param nums
     * @return
     */
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int mv = 0;
        for (int num : nums) mv = Math.max(mv, num);

        boolean[] occured = new boolean[mv + 1];
        for (int num : nums) occured[num] = true;

        int res = 0;
        for (int i = 1; i <= mv; i++) {
            for (int j = i, gcd = 0; j <= mv; j += i) {
                // 如果 x 为数组 nums 中的某个序列的最大公约数，
                // 则数组中所有能够被 x 整除的元素构成的最大公约数一定为 x
                if (occured[j]) {
                    gcd = getGCD(j, gcd);
                    if (gcd == i) {
//                        System.out.println(gcd + ", " + j);
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    private int getGCD(int a, int b) {
        return b != 0 ? getGCD(b, a % b) : a;
    }

    public static void main(String[] args) {
        NumberOfDifferentSubsequencesGCDs nd = new NumberOfDifferentSubsequencesGCDs();
        int[] nums = new int[] {6, 10, 3};
        System.out.println(nd.countDifferentSubsequenceGCDs(nums));
    }
}
