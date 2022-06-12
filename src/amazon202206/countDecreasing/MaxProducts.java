package amazon202206.countDecreasing;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxProducts {
    public static long findMaxProducts(List<Integer> products) {
        // Write your code here
        int n = products.size();
        long maxSum = 0;

        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = products.get(i);
            maxSum = Math.max(maxSum, dp[i][i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (products.get(j) > products.get(j - 1)) {
                    dp[i][j] = dp[i][j - 1] + products.get(j);
                } else {
                    long curSum = 0;
                    int cur = products.get(j);
                    for (int k = j; k >= i && cur > 0; k--, cur--) {
                        curSum += Math.min(cur, products.get(k));
                    }
                    dp[i][j] = curSum;
                }
                maxSum = Math.max(maxSum, dp[i][j]);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
//        int[] ps = new int[] {2,9,4,7,5,2};
//        int[] ps = new int[] {2,5,6,7};
//        int[] ps = new int[] {8,6,4,2};
        int[] ps = new int[] {1,2,8,5};
        List<Integer> pros = new ArrayList<>();
        for (int product : ps) {
            pros.add(product);
        }
        System.out.println(findMaxProducts(pros));
    }
}
