package leetcode._1823;

/**
 * https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 */
public class FindTheWinnerOfTheCircularGame {
    public int findTheWinner(int n, int k) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = (res + k - 1) % i + 1;
        }
        return res;
    }

    public int findTheWinnerRec(int n, int k) {
        return n == 1 ? 1 : (findTheWinnerRec(n - 1, k) + k - 1) % n + 1;
    }
}
