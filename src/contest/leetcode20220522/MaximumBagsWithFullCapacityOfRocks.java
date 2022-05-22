package contest.leetcode20220522;

import utils.ArrayUtils;

import java.util.Arrays;

public class MaximumBagsWithFullCapacityOfRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] needs = new int[n];
        int fullCnt = 0;
        for (int i = 0; i < n; i++) {
            int need = capacity[i] - rocks[i];
            needs[i] = need;
            if (need == 0) {
                fullCnt++;
            }
        }
        if (fullCnt == n) {
            return n;
        }
//        ArrayUtils.printArray(needs);
//        System.out.println(fullCnt);
        Arrays.sort(needs);
        int res = fullCnt;
        for (int i = fullCnt; i < n; i++) {
            additionalRocks -= needs[i];
            if (additionalRocks < 0) {
                return res;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumBagsWithFullCapacityOfRocks mb = new MaximumBagsWithFullCapacityOfRocks();
//        int[] capacity = new int[] {2,3,4,5};
//        int[] rocks = new int[] {1,2,4,4};
//        int additionalRocks = 2;
//        int[] capacity = new int[] {10,2,2};
//        int[] rocks = new int[] {2,2,0};
//        int additionalRocks = 100;
//        [91,54,63,99,24,45,78]
//[35,32,45,98,6,1,25]
//        17
        int[] capacity = new int[] {91,54,63,99,24,45,78};
        int[] rocks = new int[] {35,32,45,98,6,1,25};
        int additionalRocks = 19;
        System.out.println(mb.maximumBags(capacity, rocks, additionalRocks));
    }
}
