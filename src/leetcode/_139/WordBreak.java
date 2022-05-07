package leetcode._139;

import utils.ArrayUtils;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
//        for (String word : wordDict) {
//            for (int i = word.length(); i <= s.length(); i++) {
//                dp[i] = dp[i] || dp[i - word.length()] && s.startsWith(word, i - word.length());
//            }
//        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (dp[j] && wordSet.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(i + ": " + dp[i]);
//        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple","pen"));
        System.out.println(wb.wordBreak(s, wordDict));
    }
}
