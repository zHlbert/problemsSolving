package leetcode._2413;

public class SmallestEvenPossible {
    public int smallestEvenMultiple(int n) {
        return (n & 1) == 0 ? n : n << 1;
    }
}
