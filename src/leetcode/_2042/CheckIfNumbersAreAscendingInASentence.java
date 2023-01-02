package leetcode._2042;

public class CheckIfNumbersAreAscendingInASentence {
    public boolean areNumbersAscending(String s) {
        String[] tokens = s.split(" ");
        int pre = 0;
        for (String token : tokens) {
            char fc = token.charAt(0);
            if (fc >= '0' && fc <= '9') {
                int cur = 0;
                for (int i = 0; i < token.length(); i++)
                    cur = 10 * cur + (token.charAt(i) - '0');
                if (cur <= pre)
                    return false;
                pre = cur;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfNumbersAreAscendingInASentence cn = new CheckIfNumbersAreAscendingInASentence();
        System.out.println(cn.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        System.out.println(cn.areNumbersAscending("hello world 5 x 5"));
        System.out.println(cn.areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
    }
}
