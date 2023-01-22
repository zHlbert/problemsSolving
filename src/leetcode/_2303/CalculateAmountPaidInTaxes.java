package leetcode._2303;

public class CalculateAmountPaidInTaxes {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0.0;
        int last = 0;
        for (int[] bracket : brackets) {
            if (bracket[0] >= income) {
                res += (income - last) * bracket[1] / 100.0;
                break;
            }
            res += (bracket[0] - last) * bracket[1] / 100.0;
            last = bracket[0];
        }
        return res;
    }
}
