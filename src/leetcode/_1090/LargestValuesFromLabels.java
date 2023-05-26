package leetcode._1090;

import java.util.Arrays;

public class LargestValuesFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (a, b) -> values[b] - values[a]);
        int cnt = 0, res = 0;
        int[] used = new int[20010];
        for (int i = 0; i < n && cnt < numWanted; i++) {
            int label = labels[ids[i]];
            if (used[label] == useLimit) continue;
            res += values[ids[i]];
            used[label]++;
            cnt++;
        }
        return res;
    }
}
