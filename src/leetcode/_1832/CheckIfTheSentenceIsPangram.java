package leetcode._1832;

public class CheckIfTheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        boolean[] occr = new boolean[26];
        char[] sc = sentence.toCharArray();
        for (char c : sc) {
            occr[c - 'a'] = true;
        }

        for (boolean f : occr) {
            if (!f) return false;
        }
        return true;
    }
}
