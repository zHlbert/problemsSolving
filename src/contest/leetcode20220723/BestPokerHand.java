package contest.leetcode20220723;

public class BestPokerHand {
    public String bestHand(int[] ranks, char[] suits) {
        int[] rc = new int[14];
        int[] sc = new int[4];
        for (int i = 0; i < 5; i++) {
            rc[ranks[i]]++;
            sc[suits[i] - 'a']++;
        }
        for (int i : sc) {
            if (i == 5) {
                return "Flush";
            }
        }

        for (int i : rc) {
            if (i >= 3) {
                return "Three of a Kind";
            }
            if (i == 2) {
                return "Pair";
            }
        }
        return "High Card";
    }

    public static void main(String[] args) {
        BestPokerHand bph = new BestPokerHand();
        int[] ranks = new int[] {12,2,3,1,9};
        char[] suits = new char[] {'a','a','a','a','a'};
        System.out.println(bph.bestHand(ranks, suits));
    }
}
