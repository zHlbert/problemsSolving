package leetcode._1769;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        char[] sc = boxes.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i] += Math.abs(j - i) * (sc[j] - '0');
            }
        }
        return res;
    }

    public int[] minOperations1(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        char[] sc = boxes.toCharArray();
        return null;
    }
}
