package leetcode._1093;

public class StatisticsFromALargeSample {
    public double[] sampleStats(int[] count) {
        int cnt = 0, min = 256, max = -1;
        int mode = 0, maxCnt = 0;
        long sum = 0;
        for (int i = 0; i < count.length; i++) {
            int c = count[i];
            cnt += c;
            if (min == 256 && c > 0) min = i;
            if (c > 0) max = i;
            if (c > maxCnt) {
                maxCnt = c;
                mode = i;
            }
            sum += (long) i * c;
        }
        double median = 0.0, ln = -1.0, rn = -1.0;
        int l = (cnt + 1) >> 1, r = (cnt + 2) >> 1;
        int ct = 0;
        for (int i = 0; i < count.length; i++) {
            int c = count[i];
            if (c > 0) {
                ct += c;
                if (ct >= l && ln < 0) ln = i;
                if (ct >= r) {
                    rn = i;
                    median = (ln + rn) / 2;
                    break;
                }
            }
        }

        return new double[] {min, max, (double) sum / cnt, median, mode};
    }
}
