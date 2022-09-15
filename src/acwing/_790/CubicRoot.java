package acwing._790;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CubicRoot {
    private static final double eps = 1e-7;

    /**
     * 浮点二分
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double num = Double.parseDouble(reader.readLine());
        double l = -30.0, r = 30.0;
        while (r - l > eps) {
            double mid = (l + r) / 2;
            if (mid * mid * mid >= num) {
                r = mid;
            } else {
                l = mid;
            }
        }
        System.out.printf("%.6f%n", l);
    }
}
