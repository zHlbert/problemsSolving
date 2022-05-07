package contest.leetcode20210829;

import java.util.*;

/**
 * You are given a binary string binary. A subsequence of binary is considered good if it is not empty and has no leading zeros (with the exception of "0").
 *
 * Find the number of unique good subsequences of binary.
 *
 * For example, if binary = "001", then all the good subsequences are ["0", "0", "1"], so the unique good subsequences are "0" and "1". Note that subsequences "00", "01", and "001" are not good because they have leading zeros.
 * Return the number of unique good subsequences of binary. Since the answer may be very large, return it modulo 109 + 7.
 *
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 */
public class NumberOfUniqueGoodSubsequences {
    int mod = 1000000007;
    int totalNum = 0;
//    List<List<Character>> allSets = new ArrayList<>();
    LinkedList<Character> subSeq = new LinkedList<>();
    Set<String> uniqueChars = new HashSet<>();
    public int numberOfUniqueGoodSubsequences(String binary) {
        char[] chars = binary.toCharArray();
        backtracking(chars, 0);
        return totalNum;
    }

    private void backtracking(char[] chars, int startIndex) {
        if (!subSeq.isEmpty()) {
            String rmLZeroes = toNoLeadingZerosStr(subSeq);
            if (rmLZeroes != null && rmLZeroes.length() > 0) {
                if (!uniqueChars.contains(rmLZeroes)) {
                    totalNum = (totalNum + 1) % mod;
                }
                uniqueChars.add(rmLZeroes);
            }
//            allSets.add(new ArrayList<>(subSeq));
        }
        for (int i = startIndex; i < chars.length; i++) {
            subSeq.add(chars[i]);
            backtracking(chars, i + 1);
            subSeq.removeLast();
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public String toNoLeadingZerosStr(List<Character> chars) {
        if (chars.size() == 1 && chars.get(0) == '0') {
            return "0";
        }
        int i = 0;
        while (i < chars.size() && chars.get(i) == '0') {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < chars.size(); j++) {
            sb.append(chars.get(j));
        }
        return sb.toString();
    }

    public int numberOfUniqueGoodSubsequencesDP(String binary) {
        // 滚动数组
        // dp0表示以0开头的子序列个数，dp1表示以1开头的子序列个数，has0表示字符串中是否有0
        int dp0 = 0, dp1 = 0, has0 = 0, mod = (int) (1e9 + 7);
        // 降序遍历
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '0') {
                has0 = 1;
                // 当前数量 = {当前位加此前的字符串}的数量（此前的以0开头数量 + 以1开头数量） + 1（单独当前位 ‘0’）
                dp0 = (dp0 + dp1 + 1) % mod;
            } else {
                // 当前数量 = {当前位加此前的字符串}的数量（此前的以0开头数量 + 以1开头数量） + 1（单独当前位 ‘1’）
                dp1 = (dp0 + dp1 + 1) % mod;
            }
        }
        return (dp1 + has0) % mod;
    }

    public static void main(String[] args) {
        NumberOfUniqueGoodSubsequences n = new NumberOfUniqueGoodSubsequences();
        String binary = "001";
//        String binary = "111001101100000001001110110101110001100";
        System.out.println(n.numberOfUniqueGoodSubsequencesDP(binary));
    }
}
