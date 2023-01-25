package leetcode._2309;

public class GreatestEnglishLetterInUpperAndLowerCase {
    public String greatestLetter(String s) {
        boolean[] occurs = new boolean[128];
        for (char c : s.toCharArray())
            occurs[c] = true;
        for (int i = 25; i >= 0 ; i--) {
            if (occurs['A' + i] && occurs['a' + i])
                return String.valueOf((char) ('A' + i));
        }
        return "";
    }

    public static void main(String[] args) {
        GreatestEnglishLetterInUpperAndLowerCase ge = new GreatestEnglishLetterInUpperAndLowerCase();
        System.out.println(ge.greatestLetter("lEeTcOdE"));
        System.out.println(ge.greatestLetter("arRAzFif"));
        System.out.println(ge.greatestLetter("AbCdEfGhIjK"));
    }
}
