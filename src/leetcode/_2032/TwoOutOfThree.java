package leetcode._2032;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoOutOfThree {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        boolean[][] appears = new boolean[105][3];
        for (int x : nums1) appears[x][0] = true;
        for (int x : nums2) appears[x][1] = true;
        for (int x : nums3) appears[x][2] = true;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < appears.length; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++)
                cnt += appears[i][j] ? 1 : 0;
            if (cnt >= 2) res.add(i);
        }
        return res;
    }

    public List<Integer> twoOutOfThree1(int[] nums1, int[] nums2, int[] nums3) {
        int[] cnt = new int[105];
        for (int x : nums1) cnt[x] |= 1;
        for (int x : nums2) cnt[x] |= 2;
        for (int x : nums3) cnt[x] |= 4;
        System.out.println(Arrays.toString(cnt));
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++)
            if (Integer.bitCount(cnt[i]) > 1) res.add(i);
        return res;
    }

    public static void main(String[] args) {
        TwoOutOfThree tt = new TwoOutOfThree();
        int[] nums1 = new int[] {1,2,2};
        int[] nums2 = new int[] {4,3,3};
        int[] nums3 = new int[] {5};
        System.out.println(tt.twoOutOfThree1(nums1, nums2, nums3));
    }
}
