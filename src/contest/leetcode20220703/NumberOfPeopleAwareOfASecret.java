package contest.leetcode20220703;

public class NumberOfPeopleAwareOfASecret {
    int mod = (int) (1e9 + 7);
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        // dp[i][0] 表示第i天知道秘密的人数, dp[i][1] 表示第 i 天 新增的被分享秘密的人数
        long[][] dp = new long[n + 1][2];
        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i - delay; j > i - forget && j >= 0; j--) {
                dp[i][1] = (dp[i][1] + dp[j][1]) % mod;
            }
            int k = i - forget;
            long minus = k >= 0 ? dp[k][1] : 0;
            dp[i][0] = ((dp[i - 1][0] + dp[i][1]) % mod - minus + mod) % mod;
        }

        return (int) dp[n][0];
    }

    public static void main(String[] args) {
        NumberOfPeopleAwareOfASecret np = new NumberOfPeopleAwareOfASecret();
        System.out.println(np.peopleAwareOfSecret(6,2,4));
        System.out.println(np.peopleAwareOfSecret(4,1,3));
        System.out.println(np.peopleAwareOfSecret(289,7,23));
    }
}
