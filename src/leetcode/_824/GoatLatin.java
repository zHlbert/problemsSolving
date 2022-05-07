package leetcode._824;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/goat-latin/
 */
public class GoatLatin {
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    String postfix = "ma";
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder resBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (vowels.contains(Character.toLowerCase(word.charAt(0)))) {
                resBuilder.append(word).append(postfix);
            } else {
                resBuilder.append(word.substring(1)).append(word.charAt(0)).append(postfix);
            }
            resBuilder.append("a".repeat(i + 1));
            if (i + 1 < words.length) {
                resBuilder.append(" ");
            }
        }
        return resBuilder.toString();
    }

    public static void main(String[] args) {
        GoatLatin goat = new GoatLatin();
//        String sentence = "I speak Goat Latin";
        String sentence = "I speak Goat Latin";
        System.out.println(goat.toGoatLatin(sentence));
    }
}
