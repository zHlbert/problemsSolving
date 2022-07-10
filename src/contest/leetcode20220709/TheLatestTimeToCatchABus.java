package contest.leetcode20220709;

import java.util.Arrays;

public class TheLatestTimeToCatchABus {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
//        Arrays.sort(buses);
//        Arrays.sort(passengers);
//        int bl = buses.length;
//        int[] idx = new int[bl];
//        int j = 0;
//        for (int i = 0; i < buses.length; i++) {
//            int pCnt = 0;
//            while (passengers[j] <= buses[i] && pCnt < capacity && j < passengers.length) {
//                j++;
//                pCnt++;
//            }
//            idx[i] = pCnt;
//        }
//        for (int i = bl - 1; i > 0; i--) {
//            int itv = buses[i] - buses[i - 1];
//            if (itv > capacity || itv > idx[i]) {
//                return
//            }
//        }
        return 0;
    }
}
