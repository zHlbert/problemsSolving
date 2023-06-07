package leetcode._2611;

import java.util.Arrays;

public class MiceAndCheese {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> reward1[a] - reward2[a] - reward1[b] + reward2[b]);
//        System.out.println(Arrays.toString(idx));
        int res = 0;
        for (int i = 0; i < n - k; i++) {
            res += reward2[idx[i]];
        }
        for (int i = n - k; i < n; i++) {
            res += reward1[idx[i]];
        }
        return res;
    }

    public int miceAndCheese1(int[] reward1, int[] reward2, int k) {
        int res = 0;
        for (int r : reward2) {
            res += r;
        }
        int n = reward1.length;
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(num);
        for (int i = 0, j = n - 1; i < k; i++, j--) {
            res += num[j];
        }
        return res;
    }

    public static void main(String[] args) {
        MiceAndCheese mc = new MiceAndCheese();
        System.out.println(mc.miceAndCheese(new int[] {1,1,3,4}, new int[] {4,4,1,1}, 2));
        System.out.println(mc.miceAndCheese(new int[] {1,1}, new int[] {1,1}, 2));
    }
}
