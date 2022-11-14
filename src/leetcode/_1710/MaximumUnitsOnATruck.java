package leetcode._1710;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int sz = truckSize, res = 0, n = boxTypes.length;
        for (int i = 0; i < n && sz > 0; i++) {
            int boxes = Math.min(sz, boxTypes[i][0]);
            res += boxes * boxTypes[i][1];
            sz -= boxes;
        }
        return res;
    }

    /**
     * 计数排序
     * @param boxTypes
     * @param truckSize
     * @return
     */
    public int maximumUnits1(int[][] boxTypes, int truckSize) {
        int[] cnt = new int[1005];
        for (int[] boxType : boxTypes) {
            cnt[boxType[1]] += boxType[0];
        }
        int res = 0, sz = truckSize;
        for (int i = 1000; i > 0 && sz > 0; i--) {
            int boxes = Math.min(sz, cnt[i]);
            res += boxes * i;
            sz -= boxes;
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumUnitsOnATruck mu = new MaximumUnitsOnATruck();
        int[][] boxesTypes = new int[][] {{1,3},{2,2},{3,1}};
        int truckSize = 4;
        System.out.println(mu.maximumUnits1(boxesTypes, truckSize));
    }
}
