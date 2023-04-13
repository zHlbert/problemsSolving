package leetcode._2404;

import java.util.Arrays;

public class MostFrequentEvenElement {
    public int mostFrequentEven(int[] nums) {
        int[] cnt = new int[100010];
        boolean hasEven = false;
        for (int num : nums) {
            if ((num & 1) == 0) {
                cnt[num]++;
                hasEven = true;
            }
        }
        if (!hasEven) return -1;
//        System.out.println(Arrays.toString(cnt));
        int res = 0, maxN = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > maxN) {
                res = i;
                maxN = cnt[i];
            }
        }
        return res;
    }

    public int mostFrequentEven1(int[] nums) {
        int[] cnt = new int[100010];
        int res = -1, maxCnt = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                cnt[num]++;
                if (cnt[num] > maxCnt) {
                    res = num;
                    maxCnt = cnt[num];
                } else if (cnt[num] == maxCnt) {
                    res = Math.min(res, num);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MostFrequentEvenElement mf = new MostFrequentEvenElement();
        System.out.println(mf.mostFrequentEven1(new int[] {0,1,2,2,4,4,1}));
        System.out.println(mf.mostFrequentEven1(new int[] {4,4,4,9,2,4}));
        System.out.println(mf.mostFrequentEven1(new int[] {29,47,21,41,13,37,25,7}));
        System.out.println(mf.mostFrequentEven1(new int[] {0,0,0,0}));
    }
}
