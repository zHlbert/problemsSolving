package contest.leetcode20220522;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfTotalStrengthOfWizards {
    int mod = 1000000007;
    public int totalStrength(int[] strength) {
        int n = strength.length;
        long[] pPreSum = new long[n];
        long preSum = strength[0];
        pPreSum[0] = preSum;
        Deque<Integer> stack = new ArrayDeque<>(n);
        long sum = 0;
        for (int i = -1; i <= n; i++) {
            if (i >= 1 && i < n) {
                preSum = (preSum + strength[i]) % mod;
                pPreSum[i] = (pPreSum[i - 1] + preSum) % mod;
            }
            int iVal = getElement(strength, n, i);
            while (!stack.isEmpty() && getElement(strength, n, stack.peek()) > iVal) {
                int cur = stack.pop();
                int l = stack.peek();
                long cPPSum = cur - 1 >= 0 ? pPreSum[cur - 1] : 0;
                long lPPSum = l - 1 >= 0 ? pPreSum[l - 1] : 0;
                long rSum = ((cur - l) * ((pPreSum[i - 1] - cPPSum + mod) % mod)) % mod;
                long lSum = ((i - cur) * ((cPPSum - lPPSum + mod) % mod)) % mod;
                sum = (sum + (strength[cur] * ((rSum - lSum + mod) % mod)) % mod) % mod;
            }
            stack.push(i);
        }
//        ArrayUtils.printArray(preSum);
        return (int) sum;
    }

    private int getElement(int[] arr, int n, int i) {
        if (i < 0 || i >= n) {
            return Integer.MIN_VALUE;
        }
        return arr[i];
    }

    public static void main(String[] args) {
        SumOfTotalStrengthOfWizards ssm = new SumOfTotalStrengthOfWizards();
//        int[] strength = new int[] {1,3,1,2};
        int[] strength = new int[] {5,4,6};
        System.out.println(ssm.totalStrength(strength));
    }
}
