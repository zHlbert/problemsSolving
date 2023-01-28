package leetcode._2315;

public class CountAsterisks {
    public int countAsterisks(String s) {
        char[] sc = s.toCharArray();
        boolean odd = false;
        int sum = 0, between = 0;
        for (char c : sc) {
            if (c == '|') odd = !odd;
            if (c == '*') {
                sum++;
                between += odd ? 1 : 0;
            }
        }
        return sum - between;
    }

    public static void main(String[] args) {
        CountAsterisks ca = new CountAsterisks();
        System.out.println(ca.countAsterisks("l|*e*et|c**o|*de|"));
        System.out.println(ca.countAsterisks("iamprogrammer"));
        System.out.println(ca.countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
    }
}
