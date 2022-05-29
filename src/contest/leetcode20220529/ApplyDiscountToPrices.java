package contest.leetcode20220529;

import java.text.DecimalFormat;

/**
 * https://leetcode.cn/contest/weekly-contest-295/problems/apply-discount-to-prices/
 */
public class ApplyDiscountToPrices {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (words[i].charAt(0) == '$' && words[i].length() > 1) {
                boolean isNumber = true;
                String pNumStr = words[i].substring(1);
                char[] dChars = pNumStr.toCharArray();
                for (char dChar : dChars) {
                    if (!Character.isDigit(dChar)) {
                        isNumber = false;
                        break;
                    }
                }
                if (isNumber) {
                    long price = Long.parseLong(pNumStr);
                    double discounted = 1.0 * price * (100 - discount) / 100.0;
                    String discountedStr = "$" + String.format("%.2f", discounted);
                    words[i] = discountedStr;
                }
            }
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        ApplyDiscountToPrices adp = new ApplyDiscountToPrices();
        String sentence = "706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6";
        int discount = 50;
        System.out.println(adp.discountPrices(sentence, discount));
    }
}
