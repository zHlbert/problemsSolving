package amazon202206.countDecreasing;

import utils.ArrayUtils;

import java.util.*;

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

    public static long findMaxProducts1(List<Integer> products) {
        int n = products.size();
        long maxSum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && products.get(stack.peek()) >= products.get(i)) {
                stack.pop();
            }
            stack.push(i);
            int sum = 0;
//            int cur = products.get(st)
            for (int j = stack.peek(), cur = products.get(j); j >= 0 && cur > 0; j--) {
                int min = Math.min(products.get(j), cur);
                sum += min;
                cur = min - 1;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
//        int[] ps = new int[] {2,9,4,7,5,2};
//        int[] ps = new int[] {2,5,6,7};
//        int[] ps = new int[] {8,6,4,2};
        int[] ps = new int[] {5,7,6,5};
        List<Integer> pros = new ArrayList<>();
        for (int product : ps) {
            pros.add(product);
        }
        System.out.println(findMaxProducts1(pros));
    }
}
