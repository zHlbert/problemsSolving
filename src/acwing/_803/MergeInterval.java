package acwing._803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] itv = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] itvs = reader.readLine().split(" ");
            int l = Integer.parseInt(itvs[0]), r = Integer.parseInt(itvs[1]);
            itv[i][0] = l;
            itv[i][1] = r;
        }
        Arrays.sort(itv, (i1, i2) -> {
            if (i1[0] == i2[0]) {
                return i1[1] - i2[1];
            }
            return i1[0] - i2[0];
        });

        List<int[]> res = new ArrayList<>();
        res.add(itv[0]);
        for (int i = 1; i < n; i++) {
            int[] last = res.get(res.size() - 1);
            if (itv[i][0] <= last[1]) {
                last[1] = Math.max(last[1], itv[i][1]);
            } else {
                res.add(new int[] {itv[i][0], itv[i][1]});
            }
        }
        System.out.println(res.size());
        reader.close();
    }
}
