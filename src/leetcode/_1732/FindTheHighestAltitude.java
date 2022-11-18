package leetcode._1732;

public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int res = 0, cur = 0;
        for (int g : gain) {
            cur += g;
            res = Math.max(res, cur);
        }
        return res;
    }
}
