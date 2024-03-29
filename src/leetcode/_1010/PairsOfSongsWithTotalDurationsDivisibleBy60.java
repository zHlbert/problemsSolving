package leetcode._1010;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] cnt = new int[60];
        for (int t : time) {
            cnt[t % 60]++;
        }

        long res = (long) cnt[0] * (cnt[0] - 1) / 2 + (long) cnt[30] * (cnt[30] - 1) / 2;
        for (int i = 1; i < 30; i++) {
            res += (long) cnt[i] * cnt[60 - i];
        }
        return (int) res;
    }
}
