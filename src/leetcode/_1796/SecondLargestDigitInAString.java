package leetcode._1796;

public class SecondLargestDigitInAString {
    public int secondHighest(String s) {
        char[] sc = s.toCharArray();
        boolean[] ds = new boolean[10];
        for (char c : sc) {
            if (!Character.isDigit(c)) {
                continue;
            }
            ds[c - '0'] = true;
        }

        boolean first = false;
        for (int i = 9; i >= 0; i--) {
            if (ds[i]) {
                if (!first) first = true;
                else return i;
            }
        }
        return -1;
    }
}
