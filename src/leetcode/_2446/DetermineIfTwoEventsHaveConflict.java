package leetcode._2446;

import java.util.Arrays;

public class DetermineIfTwoEventsHaveConflict {
    public boolean haveConflict(String[] event1, String[] event2) {
        String s1 = event1[0], e1 = event1[1], s2 = event2[0], e2 = event2[1];
        int s1t = getTime(s1), e1t = getTime(e1), s2t = getTime(s2), e2t = getTime(e2);
        return s1t <= e2t && s2t <= e1t;
    }

    private int getTime(String t) {
        return (t.charAt(0) - '0') * 600 + (t.charAt(1) - '0') * 60 + (t.charAt(3) - '0') * 10 + t.charAt(4) - '0';
    }
}
