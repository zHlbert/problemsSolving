package contest.leetcode20220612;

public class FairDistributionOfCookies {
    int fairness = Integer.MAX_VALUE;
    int n, k;
//    boolean[] used;
    public int distributeCookies(int[] cookies, int k) {
        n = cookies.length;
        this.k = k;
        int[] dis = new int[k];
//        used = new boolean[n];
        backtrack(cookies, 0, dis);
        return fairness;
    }

    private void backtrack(int[] cookies, int idx, int[] dis) {
        if (idx == cookies.length) {
            int maxC = 0;
            for (int i = 0; i < k; i++) {
                maxC = Math.max(maxC, dis[i]);
            }
            fairness = Math.min(fairness, maxC);
            return;
        }
        for (int i = 0; i < k; i++) {
            if (dis[i] + cookies[idx] <= fairness) {
                dis[i] += cookies[idx];
                backtrack(cookies, idx + 1, dis);
                dis[i] -= cookies[idx];
            }
        }
    }

    public static void main(String[] args) {
        FairDistributionOfCookies fd = new FairDistributionOfCookies();
//        int[] cookies = new int[] {8,15,10,20,8};
//        int k = 2;
        int[] cookies = new int[] {6,1,3,2,2,4,1,2};
        int k = 3;
        System.out.println(fd.distributeCookies(cookies, k));
    }
}
