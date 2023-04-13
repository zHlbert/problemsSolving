package leetcode._1023;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
    /**
     * 双指针
     * @param queries
     * @param pattern
     * @return
     */
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        int n = pattern.length();
        char[] pc = pattern.toCharArray();
        for (String q : queries) {
            boolean match = true;
            int pi = 0;
            int qn = q.length();
            for (int j = 0; j < qn; j++) {
                if (pi < n && pc[pi] == q.charAt(j)) {
                    pi++;
                } else if (Character.isUpperCase(q.charAt(j))) {
                    match = false;
                    break;
                }
            }
//            System.out.println(q + ", " + match);
            if (pi < n) match = false;
            res.add(match);
        }
        return res;
    }

    public static void main(String[] args) {
        CamelcaseMatching cm = new CamelcaseMatching();
        System.out.println(cm.camelMatch(new String[] {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"},"FB"));;
    }
}
