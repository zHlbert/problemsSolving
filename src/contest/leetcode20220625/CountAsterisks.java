package contest.leetcode20220625;

/**
 * https://leetcode.cn/problems/greatestcount-asterisks/
 */
public class CountAsterisks {
    public int countAsterisks(String s) {
        String[] split = s.split("\\|", -1);
        int res = 0;
        for (int i = 0; i < split.length; i += 2) {
            String s1 = split[i];
            if (s1.isEmpty()) {
                continue;
            }
            char[] chars = s1.toCharArray();
            for (char c : chars) {
                if (c == '*') {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountAsterisks ca = new CountAsterisks();
        System.out.println(ca.countAsterisks("l|*e*et|c**o|*de|"));
        System.out.println(ca.countAsterisks("iamprogrammer"));
        System.out.println(ca.countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
        System.out.println(ca.countAsterisks("|uar|e**|b|e***au|tifu|**|7*"));
    }
}
