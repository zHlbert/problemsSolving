package contest.leetcode20210724;

/**
 * Given a string s, return true if s is a good string, or false otherwise.
 *
 * A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).
 */
public class CheckIfAllCharactersHaveEqualNumberOfOccurrences {
    public boolean areOccurrencesEqual(String s) {
        int[] occ = new int[26];
        for (char c : s.toCharArray()) {
            occ[(c - 'a')]++;
        }
        boolean equals = true;
        int count = 0;
        for (int j : occ) {
            if (j != 0) {
                if (count == 0) {
                    count = j;
                } else {
                    equals = count == j;
                    if (!equals)
                        break;
                }
            }
        }
        return equals;
    }

    public static void main(String[] args) {
        CheckIfAllCharactersHaveEqualNumberOfOccurrences c = new CheckIfAllCharactersHaveEqualNumberOfOccurrences();
        System.out.println(c.areOccurrencesEqual("abcabc"));
        System.out.println(c.areOccurrencesEqual("aaabb"));
        System.out.println(c.areOccurrencesEqual("ccaab"));
        System.out.println(c.areOccurrencesEqual("abv"));
        System.out.println(c.areOccurrencesEqual("c"));
    }
}
