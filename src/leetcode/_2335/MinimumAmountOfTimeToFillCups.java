package leetcode._2335;

public class MinimumAmountOfTimeToFillCups {
    /**
     * 贪心
     * @param amount
     * @return
     */
    public int fillCups(int[] amount) {
        int max = 0, sum = 0;
        for (int x : amount) {
            max = Math.max(max, x);
            sum += x;
        }
        return max > sum - max ? max : (sum + 1) >> 1;
    }

    public static void main(String[] args) {
        MinimumAmountOfTimeToFillCups ma = new MinimumAmountOfTimeToFillCups();
        System.out.println(ma.fillCups(new int[] {1,4,2}));
        System.out.println(ma.fillCups(new int[] {5,4,4}));
        System.out.println(ma.fillCups(new int[] {5,0,0}));
    }
}
