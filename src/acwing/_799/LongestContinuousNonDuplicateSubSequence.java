package acwing._799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestContinuousNonDuplicateSubSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] ns = reader.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(ns[i]);
        }

        int[] cnt = new int[100010];
        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            cnt[arr[i]]++;
            while (cnt[arr[i]] > 1) {
                cnt[arr[j]]--;
                j++;
            }

            res = Math.max(res, i - j + 1);
        }
        System.out.println(res);
        reader.close();
    }
}
