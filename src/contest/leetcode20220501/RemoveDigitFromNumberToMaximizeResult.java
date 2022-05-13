package contest.leetcode20220501;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a string number representing a positive integer and a character digit.
 *
 * Return the resulting string after removing exactly one occurrence of digit from number such that the value of the resulting string in decimal form is maximized. The test cases are generated such that digit occurs at least once in number.
 */
public class RemoveDigitFromNumberToMaximizeResult {
    public String removeDigit(String number, char digit) {
        char[] chars = number.toCharArray();
        List<Integer> idxList = new ArrayList<>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == digit) {
                idxList.add(i);
            }
        }
        StringBuilder sb = new StringBuilder(number);
        if (idxList.size() == 1) {
            return sb.deleteCharAt(idxList.get(0)).toString();
        }
        boolean hasDown = false;
        for (int idx : idxList) {
            if (idx < chars.length - 1 && chars[idx] < chars[idx + 1]) {
                return sb.deleteCharAt(idx).toString();
            } else if (idx < chars.length - 1 && chars[idx] > chars[idx + 1]) {
                hasDown = true;
            }
        }
        if (hasDown) {
            return sb.deleteCharAt(idxList.get(idxList.size() - 1)).toString();
        }
        return sb.deleteCharAt(idxList.get(0)).toString();
    }

    public static void main(String[] args) {
        RemoveDigitFromNumberToMaximizeResult rd = new RemoveDigitFromNumberToMaximizeResult();
        String number = "73197";
        char digit = '7';
        System.out.println(rd.removeDigit(number, digit));
    }
}
