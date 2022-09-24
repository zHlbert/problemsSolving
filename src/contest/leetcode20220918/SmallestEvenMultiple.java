package contest.leetcode20220918;

public class SmallestEvenMultiple {
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : 2 * n;
    }
}
