package leetcode._1805;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDifferentIntegersInAString {
    public int numDifferentIntegers(String word) {
        char[] sc = word.toCharArray();
        Set<String> numSet = new HashSet<>();
        StringBuilder sb = null;
        int n = sc.length;
        for (int i = 0; i < n; i++) {
            if (sc[i] >= '0' && sc[i] <= '9') {
                sb = new StringBuilder();
                sb.append(sc[i++]);
                while (i < n && sc[i] >= '0' && sc[i] <= '9') {
                    sb.append(sc[i++]);
                }
            }
            if (sb != null) {
                int j = 0;
                while (j < sb.length() - 1 && sb.charAt(j) == '0') {
                    j++;
                }
                numSet.add(sb.substring(j));
            }
        }
        return numSet.size();
    }
}
