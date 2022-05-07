package contest.leetcode20210815;

/**
 * Given an array of strings patterns and a string word, return the number of strings in patterns that exist as a substring in word.
 *
 * A substring is a contiguous sequence of characters within a string.
 */
public class NumberOfStringsThatAppearAsSubstringsInWord {
    public int numOfStrings(String[] patterns, String word) {
        int result = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfStringsThatAppearAsSubstringsInWord n = new NumberOfStringsThatAppearAsSubstringsInWord();
        System.out.println(n.numOfStrings(new String[] {"1"}, "1"));
    }
}
