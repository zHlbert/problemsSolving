package leetcode._1017;

public class ConvertToBaseNeg2 {
    public String baseNeg2(int n) {
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int rm = n & 1;
            sb.append(rm);
            n -= rm;
            n /= -2;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        ConvertToBaseNeg2 cb = new ConvertToBaseNeg2();
        System.out.println(cb.baseNeg2(2));
        System.out.println(cb.baseNeg2(3));
        System.out.println(cb.baseNeg2(4));
    }
}
