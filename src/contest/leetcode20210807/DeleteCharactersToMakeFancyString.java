package contest.leetcode20210807;

/**
 * A fancy string is a string where no three consecutive characters are equal.
 *
 * Given a string s, delete the minimum possible number of characters from s to make it fancy.
 *
 * Return the final string after the deletion. It can be shown that the answer will always be unique.
 */
public class DeleteCharactersToMakeFancyString {
    public String makeFancyString(String s) {
        if (s.length() < 3) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() < 2) {
                sb.append(c);
            } else if (c != sb.charAt(sb.length() - 1) || c != sb.charAt(sb.length() - 2)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
