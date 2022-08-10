package leetcode._1417;

import java.util.ArrayList;
import java.util.List;

public class ReformatTheString {
    public String reformat(String s) {
        char[] chars = s.toCharArray();
        List<Character> digits = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        for (char c : chars) {
            if (Character.isDigit(c))
                digits.add(c);
            else
                letters.add(c);
        }
        if (Math.abs(digits.size() - letters.size()) > 1) {
            return "";
        }

        int minL = Math.min(digits.size(), letters.size());
        StringBuilder resSb = new StringBuilder();
        for (int i = 0; i < minL; i++) {
            resSb.append(digits.get(i));
            resSb.append(letters.get(i));
        }
        if (digits.size() > minL)
            resSb.append(digits.get(minL));
        else if (letters.size() > minL)
            resSb.insert(0, letters.get(minL));

        return resSb.toString();
    }

    public String reformat1(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        char[] digits = new char[n];
        char[] letters = new char[n];
        int n1 = 0, n2 = 0;
        for (char c : chars) {
            if (Character.isDigit(c))
                digits[n1++] = c;
            else
                letters[n2++] = c;
        }
        if (Math.abs(n1 - n2) > 1) {
            return "";
        }
        int minL = Math.min(n1, n2);
        StringBuilder resSb = new StringBuilder();
        for (int i = 0; i < minL; i++) {
            resSb.append(digits[i]);
            resSb.append(letters[i]);
        }
        if (n1 > minL) {
            resSb.append(digits[minL]);
        } else if (n2 > minL) {
            resSb.insert(0, letters[minL]);
        }
        return resSb.toString();
    }
}
