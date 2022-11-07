package leetcode._1684;

public class CountTheNumberOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] app = new boolean[26];
        for (char c : allowed.toCharArray()) {
            app[c - 'a'] = true;
        }
        int res = 0;
        for (String w : words) {
            boolean consistent = true;
            for (char c : w.toCharArray()) {
                if (!app[c - 'a']) {
                    consistent = false;
                    break;
                }
            }
            res += consistent ? 1 : 0;
        }
        return res;
    }
}
