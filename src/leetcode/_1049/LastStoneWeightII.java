package leetcode._1049;

public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[] dp = new int[15001];
        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }
        return sum - dp[target] - dp[target];
    }

    public static void main(String[] args) {
        int[] stones = new int[] {2,7,4,1,8,1};
        LastStoneWeightII l = new LastStoneWeightII();
        System.out.println(l.lastStoneWeightII(stones));
    }
}
