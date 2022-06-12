package contest.leetcode20220612;

import java.io.Serializable;

public class CalculateAmountPaidInTaxes {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0.0;
        int i = 0;
        for (; i < brackets.length; i++) {
            if (income <= brackets[i][0]) {
                break;
            }
        }
        for (int j = 0; j < i; j++) {
            int pre = j > 0 ? brackets[j - 1][0] : 0;
            res += (brackets[j][0] - pre) * brackets[j][1] / 100.0;
        }

        int base = i > 0 ? brackets[i - 1][0] : 0;
        res += (income - base) * brackets[i][1] / 100.0;
        return res;
    }

    public static void main(String[] args) {
        CalculateAmountPaidInTaxes ca = new CalculateAmountPaidInTaxes();
        int[][] brackets = new int[][] {{3,50},{7,10},{12,25}};
        int income = 10;
        System.out.println(ca.calculateTax(brackets, income));
    }
}
