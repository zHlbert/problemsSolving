package leetcode._2455;

public class AverageValueOfEvenNumbersThatAreDivisibleByThree {
    public int averageValue(int[] nums) {
        int c = 0, sum = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                c++;
                sum += num;
            }
        }
        return c == 0 ? 0 : sum / c;
    }
}
