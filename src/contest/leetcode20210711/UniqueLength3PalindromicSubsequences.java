package contest.leetcode20210711;

import java.util.*;

/**
 * Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
 *
 * Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
 *
 * A palindrome is a string that reads the same forwards and backwards.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 */
public class UniqueLength3PalindromicSubsequences {
    public int countPalindromicSubsequence(String s) {
        Map<Character, List<Integer>> chCountMap = new HashMap<>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (!chCountMap.containsKey(charArr[i])) {
                chCountMap.put(charArr[i], new ArrayList<>());
            }
            chCountMap.get(charArr[i]).add(i);
        }
        Set<Character> pSet = new HashSet<>(26);
        int ans = 0;
        for (List<Integer> occ : chCountMap.values()) {
            pSet.clear();
            if (occ.size() >= 3) {
                ans++;
            }
            if (occ.size() >= 2) {
                for (int i = 0; i < occ.size() - 1; i++) {
                    int first = occ.get(i);
                    int second = occ.get(i + 1);
                    if (second - first >= 1) {
                        for (int j = first + 1; j < second; j++) {
                            if (!pSet.contains(charArr[j])) {
                                pSet.add(charArr[j]);
                                ans++;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        UniqueLength3PalindromicSubsequences u = new UniqueLength3PalindromicSubsequences();
        System.out.println(u.countPalindromicSubsequence("aabca"));
    }
}
