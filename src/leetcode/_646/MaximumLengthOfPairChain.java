package leetcode._646;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain {
    /**
     * 贪心
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(p -> p[1]));
        int res = 0, cur = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > cur) {
                cur = pair[1];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumLengthOfPairChain ml = new MaximumLengthOfPairChain();
//        int[][] pairs = new int[][] {{1,2},{2,3},{3,4}};
        int[][] pairs = new int[][] {{1,2},{7,8},{4,5}};
        System.out.println(ml.findLongestChain(pairs));
    }
}
