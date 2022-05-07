package leetcode._17;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinationsOfAPhoneNumber {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    String[] digitMap = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        backtracking(digits, 0);
        return res;
    }

    private void backtracking(String digits, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
//        for (int i = index; i < digits.length(); i++) {
            int digit = digits.charAt(index) - '0';
            String letters = digitMap[digit];
            for (int j = 0; j < letters.length(); j++) {
                sb.append(letters.charAt(j));
                backtracking(digits, index + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
//        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber();
        System.out.println(l.letterCombinations("79"));
    }
}
