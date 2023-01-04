package leetcode._1802;

public class MaximumValueAtAGivenIndexInABoundedArray {
    int n, index;
    public int maxValue(int n, int index, int maxSum) {
        this.n = n;
        this.index = index;
        int l = 0, r = maxSum;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (getSum(mid) <= maxSum) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

//    private long getSum(int val) {
//        long sum = 0;
//        if (val - index <= 1)
//            sum += (long) (val + val - index) * (index + 1) / 2;
//        else
//            sum += (long) val * (1 + val) / 2 + index - val + 1;
//
//        if (val - (n - index) <= 1)
//            sum += (long) (val + val - n + index) * (n - index) / 2;
//        else
//            sum += (long) val * (1 + val) / 2 + n - index - index + val - 1;
//
//        sum -= val;
//        return sum;
//    }

    // 贪心 + 二分
    private long getSum(int val) {
        int left = index;
        int right = n - index - 1;
        return val + cal(val, left) + cal(val, right);
    }

    private long cal(int big, int length) {
        if (length + 1 < big) {
            int small = big - length;
            return (long) (big + small - 1) * length / 2;
        } else {
            int ones = length - (big - 1);
            return (long) big * (big - 1) / 2 + ones;
        }
    }
}
