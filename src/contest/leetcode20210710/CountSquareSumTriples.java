package contest.leetcode20210710;

/**
 * A square triple (a,b,c) is a triple where a, b, and c are integers and a2 + b2 = c2.
 *
 * Given an integer n, return the number of square triples such that 1 <= a, b, c <= n.
 */
public class CountSquareSumTriples {
    public int countTriples(int n) {
        int count = 0;
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i; j <= n - 1; j++) {
                for (int k = j; k <= n; k++) {
                    if (i * i + j * j == k * k)
                        count++;
                }
            }
        }
        return count * 2;
    }
}
