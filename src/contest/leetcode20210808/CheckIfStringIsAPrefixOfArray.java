package contest.leetcode20210808;

/**
 * Given a string s and an array of strings words, determine whether s is a prefix string of words.
 *
 * A string s is a prefix string of words if s can be made by concatenating the first k strings in words for some positive k no larger than words.length.
 *
 * Return true if s is a prefix string of words, or false otherwise.
 */
public class CheckIfStringIsAPrefixOfArray {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (s.equals(sb.toString())) {
                return true;
            }
            sb.append(word);
        }
        return s.equals(sb.toString());
    }
}
