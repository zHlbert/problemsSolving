package leetcode._2178;

import java.util.ArrayList;
import java.util.List;

public class MaximumSplitOfPositiveEvenIntegers {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if ((finalSum & 1) == 1) return res;
        long finalSum1 = finalSum / 2;
        long l = 1, r = 100000L;
        while (l < r) {
            long mid = (l + r + 1) / 2;
            if (mid * (mid + 1) / 2 <= finalSum1) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        for (int i = 1; i <= l - 1; i++) {
            res.add((long) 2 * i);
        }
        long sum = l * (l - 1);
        long remains = finalSum - sum;
        if (remains > 0) res.add(remains);
        return res;
    }

    public static void main(String[] args) {
        MaximumSplitOfPositiveEvenIntegers ms = new MaximumSplitOfPositiveEvenIntegers();
        System.out.println(ms.maximumEvenSplit(12L));
        System.out.println(ms.maximumEvenSplit(7L));
        System.out.println(ms.maximumEvenSplit(28L));
        System.out.println(ms.maximumEvenSplit(228L));
    }
}
