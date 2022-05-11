package leetcode._438;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int pl = p.length();
        int sl = s.length();
        List<Integer> res = new ArrayList<>();
        if (pl > sl) {
            return res;
        }
        int[] need = new int[26];
        char[] pChars = p.toCharArray();
        for (char pChar : pChars) {
            need[pChar - 'a']++;
        }
        char[] sChars = s.toCharArray();
        int[] curr = new int[26];
        for (int i = 0, j = 0; i < sl; i++) {
            int idx = sChars[i] - 'a';
            curr[idx]++;
            while (j <= i && curr[idx] > need[idx]) {
                curr[sChars[j] - 'a']--;
                j++;
            }
            if (i - j + 1 == pl) {
                res.add(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString faa = new FindAllAnagramsInAString();
        String s = "acbab";
        String p = "ab";
        System.out.println(faa.findAnagrams(s, p));
    }
}
