package leetcode._2357;

public class MakeArrayZeroBySubtractingEqualAmounts {
    public int minimumOperations(int[] nums) {
        boolean[] occr = new boolean[105];
        int res = 0;
        for (int x : nums) {
            if (x != 0 && !occr[x]) res++;
            occr[x] = true;
        }
        return res;
    }
}
