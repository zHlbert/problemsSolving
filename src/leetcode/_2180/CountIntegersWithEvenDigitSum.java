package leetcode._2180;

public class CountIntegersWithEvenDigitSum {
    public int countEven(int num) {
        if (num <= 9)
            return num / 2;
        int t = num;
        int[] digits = new int[5];
        int c = 0;
        while (t != 0) {
            digits[c++] = t % 10;
            t /= 10;
        }
        int pre = num - digits[0];
        int res = pre / 2 - 1;
        int pdSum = 0;
        for (int i = 1; i < c; i++) pdSum += digits[i];
        res += (pdSum & 1) == 1 ? digits[0] + 1 >> 1 : (digits[0] >> 1) + 1;
        return res;
    }

    public static void main(String[] args) {
        CountIntegersWithEvenDigitSum ce = new CountIntegersWithEvenDigitSum();
        System.out.println(ce.countEven(4));
        System.out.println(ce.countEven(30));
        System.out.println(ce.countEven(31));
    }
}
