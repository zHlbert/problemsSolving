package leetcode._43;

/**
 * https://leetcode.cn/problems/multiply-strings/
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        int[] product = new int[n1 + n2];
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        for (int i = n1 - 1; i >= 0; i--) {
            int d1 = chars1[i] - '0';
            for (int j = n2 - 1; j >= 0; j--) {
                int d2 = chars2[j] - '0';
                int sum = product[i + j + 1] + d1 * d2;
                product[i + j + 1] = sum % 10;
                product[i + j] += sum / 10;
            }
        }

        StringBuilder resSb = new StringBuilder();
        for (int i = 0; i < n1 + n2; i++) {
            if (i == 0 && product[i] == 0) {
                continue;
            }
            resSb.append(product[i]);
        }
        return resSb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();
        String num1 = "123";
        String num2 = "456";
        System.out.println(ms.multiply(num1, num2));
    }
}
