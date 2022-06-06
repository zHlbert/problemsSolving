package leetcode._875;

/**
 * https://leetcode.cn/problems/koko-eating-bananas/
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int high = piles[0], low = 1;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int k = high;
        while (low < high) {
            int speed = ((high - low) >> 1) + low;
            long time = getTime(piles, speed);
            if (time <= h) {
                k = speed;
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        return k;
    }

    private long getTime(int[] piles, int speed) {
        long time = 0;
        for (int pile : piles) {
            time += (pile + speed - 1) / speed;
        }
        return time;
    }

    public static void main(String[] args) {
        KokoEatingBananas keb = new KokoEatingBananas();
        int[] piles = new int[] {3,6,7,11};
        int h = 8;
        System.out.println(keb.minEatingSpeed(piles, h));
    }
}
