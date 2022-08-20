package leetcode._1455;

public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            if (s.startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
