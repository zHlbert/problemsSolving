package leetcode._478;

import java.util.Random;

/**
 * https://leetcode.cn/problems/generate-random-point-in-a-circle/
 */
public class GenerateRandomPointInACircle {

}

class Solution {
    Random random;
    double r, xc, yc;
    public Solution(double radius, double x_center, double y_center) {
        random = new Random();
        this.r = radius;
        this.xc = x_center;
        this.yc = y_center;
    }

    public double[] randPoint() {
        while (true) {
            double x = random.nextDouble() * 2 * r - r;
            double y = random.nextDouble() * 2 * r - r;
            if (x * x + y * y <= r * r) {
                return new double[] {xc + x, yc + y};
            }
        }
    }

    // 概率密度函数 + 累计分布函数
    // https://leetcode.cn/problems/generate-random-point-in-a-circle/solution/zai-yuan-nei-sui-ji-sheng-cheng-dian-by-qp342/
    public double[] randPoint1() {
        double rr = Math.sqrt(random.nextDouble());
        double theta = random.nextDouble() * 2 * Math.PI;
        return new double[] {xc + r * rr * Math.cos(theta), yc + r * rr * Math.sin(theta)};
    }
}
