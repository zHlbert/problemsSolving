package contest.lccup22;

public class TemperatureTrend {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int res = 0, start = -1;
        int n = temperatureA.length;
        for (int i = 1; i < n; i++) {
            int da = temperatureA[i] - temperatureA[i - 1];
            int db = temperatureB[i] - temperatureB[i - 1];
            if (da == 0 && db == 0 || da * db > 0) {
                if (start == -1) {
                    start = i - 1;
                }
                res = Math.max(res, i - start);
            } else {
                start = -1;
            }
        }
        return res;
    }
}
