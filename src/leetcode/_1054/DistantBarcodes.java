package leetcode._1054;

import utils.ArrayUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/distant-barcodes/
 */
public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] cnt = new int[10001];
        int maxBar = 0, minBar = 10001;
        for (int barcode : barcodes) {
            cnt[barcode]++;
            maxBar = Math.max(maxBar, barcode);
            minBar = Math.min(minBar, barcode);
        }

        PriorityQueue<int[]> pQueue = new PriorityQueue<>(Comparator.comparing(a -> a[1], Comparator.reverseOrder()));
        for (int i = minBar; i <= maxBar; i++) {
            if (cnt[i] > 0) {
                pQueue.add(new int[] {i, cnt[i]});
            }
        }
        for (int i = 0; i < barcodes.length; i++) {
            int[] peek0 = pQueue.poll();
            if (i > 0 && peek0[0] == barcodes[i - 1]) {
                int[] peek1 = pQueue.poll();
                pollAndPut(barcodes, pQueue, i, peek1);
                pQueue.add(peek0);
            } else {
                pollAndPut(barcodes, pQueue, i, peek0);
            }
        }
        return barcodes;
    }

    private void pollAndPut(int[] barcodes, PriorityQueue<int[]> pQueue, int i, int[] peek) {
        barcodes[i] = peek[0];
        peek[1]--;
        if (peek[1] > 0) {
            pQueue.add(peek);
        }
    }

    public int[] rearrangeBarcodesOddEven(int[] barcodes) {
        int[] cnt = new int[10001];
        int maxFreq = 0, maxFreqBar = 0;
        int maxBar = 0, minBar = 10001;
        for (int barcode : barcodes) {
            cnt[barcode]++;
            maxBar = Math.max(maxBar, barcode);
            minBar = Math.min(minBar, barcode);
            if (cnt[barcode] > maxFreq) {
                maxFreq = cnt[barcode];
                maxFreqBar = barcode;
            }
        }
        int index = 0, len = barcodes.length;
        // 先用出现最多的数填充[0, 2, 4, ...]
        while (cnt[maxFreqBar] > 0) {
            barcodes[index] = maxFreqBar;
            index += 2;
            cnt[maxFreqBar]--;
        }
        for (int i = 0; i < cnt.length; i++) {
            while (cnt[i] > 0) {
                // 下标已经超出长度，从1开始
                if (index >= len) {
                    index = 1;
                }
                barcodes[index] = i;
                index += 2;
                cnt[i]--;
            }
        }
        return barcodes;
    }

    public static void main(String[] args) {
        DistantBarcodes db = new DistantBarcodes();
        int[] barcodes = new int[] {1,1,1,1,2,2,3,3};
        ArrayUtils.printArray(db.rearrangeBarcodesOddEven(barcodes));
    }
}
