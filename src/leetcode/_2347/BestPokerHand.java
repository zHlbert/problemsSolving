package leetcode._2347;

public class BestPokerHand {
    public String bestHand(int[] ranks, char[] suits) {
        if (suits[0] == suits[1] && suits[1] == suits[2] && suits[2] == suits[3] && suits[3] == suits[4])
            return "Flush";
        int[] cnt = new int[14];
        for (int rank : ranks)
            cnt[rank]++;

        int r = 1;
        for (int i = 1; i < 14; i++) {
            if (cnt[i] >= 3)
                return "Three of a Kind";
            r = Math.max(r, cnt[i]);
        }
        return r == 1 ? "High Card" : "Pair";
    }
}
