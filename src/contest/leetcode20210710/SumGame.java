package contest.leetcode20210710;

/**
 * Alice and Bob take turns playing a game, with Alice starting first.
 *
 * You are given a string num of even length consisting of digits and '?' characters. On each turn, a player will do the following if there is still at least one '?' in num:
 *
 * Choose an index i where num[i] == '?'.
 * Replace num[i] with any digit between '0' and '9'.
 * The game ends when there are no more '?' characters in num.
 *
 * For Bob to win, the sum of the digits in the first half of num must be equal to the sum of the digits in the second half. For Alice to win, the sums must not be equal.
 *
 * For example, if the game ended with num = "243801", then Bob wins because 2+4+3 = 8+0+1. If the game ended with num = "243803", then Alice wins because 2+4+3 != 8+0+3.
 * Assuming Alice and Bob play optimally, return true if Alice will win and false if Bob will win.
 *
 *
 */
public class SumGame {
    public boolean sumGame(String num) {
        int len = num.length();
        String leftStr = num.substring(0, len / 2);
        String rightStr = num.substring(len / 2);
        int leftSum = 0, rightSum = 0;
        int leftNumCount = 0, rightNumCount = 0;
        char[] leftArr = leftStr.toCharArray();
        char[] rightArr = rightStr.toCharArray();
        for (char c : leftArr) {
            if (c != '?') {
                leftSum += c - '0';
                leftNumCount++;
            }
        }
        for (char c : rightArr) {
            if (c != '?') {
                rightSum += c - '0';
                rightNumCount++;
            }
        }
        int sumDiff = leftSum - rightSum;
        int leftRes = leftArr.length - leftNumCount;
        int rightRes = rightArr.length - rightNumCount;
        if (leftNumCount == rightNumCount) {
            if (leftRes == 0) {
                return sumDiff != 0;
            }
            return Math.abs(sumDiff) / leftRes > 9;
        } else {
//            int countDiff = leftNumCount - rightNumCount;
            int resDiff = leftRes - rightRes;
            if (Math.abs(resDiff) % 2 == 1) {
                return true;
            } else {
                return sumDiff != (-9 * resDiff / 2);
            }
        }
    }

    public boolean sumGame1(String num) {
        int n = num.length(), x = 0, A = 0, B = 0;
        for (int i = 0; i < n >> 1; i++) {
             if (num.charAt(i) == '?') {
                 A++;
             } else {
                 x += (num.charAt(i) - '0');
             }
        }
        for (int i = n >> 1; i < n; i++) {
            if (num.charAt(i) == '?') {
                B++;
            } else {
                x -= (num.charAt(i) - '0');
            }
        }
        if ((A + B) % 2 == 1) {
            return true;
        }
        return (x - 9 * B + (A + B) / 2 * 9) != 0;
    }

    public static void main(String[] args) {
        SumGame s = new SumGame();
        System.out.println(s.sumGame1("9?"));
    }
}
