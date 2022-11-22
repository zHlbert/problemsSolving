package leetcode._1742;

public class MaximumNumberOfBallsInABox {
    public int countBalls(int lowLimit, int highLimit) {
        int[] cnt = new int[55];
        int mc = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int m = i, sum = 0;
            while (m > 0) {
                sum += m % 10;
                m /= 10;
            }
            cnt[sum]++;
            mc = Math.max(mc, cnt[sum]);
        }
        return mc;
    }

    public static void main(String[] args) {
        MaximumNumberOfBallsInABox mn = new MaximumNumberOfBallsInABox();
        System.out.println(mn.countBalls(1, 10));
        System.out.println(mn.countBalls(5, 15));
        System.out.println(mn.countBalls(19, 28));
    }
}
