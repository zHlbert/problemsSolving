package leetcode._1592;

import java.util.ArrayList;
import java.util.List;

public class RearrangeSpacesBetweenWords {
    public String reorderSpaces(String text) {
        int blk = 0;
        List<String> strs = new ArrayList<>();
        char[] chars = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c == ' ') {
                blk++;
                if (sb.length() > 0) {
                    strs.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            strs.add(sb.toString());
        }
        int wc = strs.size();
        int itv = wc > 1 ? blk / (wc - 1) : 0;
        StringBuilder resSb = new StringBuilder();
        resSb.append(strs.get(0));
        for (int i = 1; i < wc; i++) {
            resSb.append(" ".repeat(itv));
            blk -= itv;
            resSb.append(strs.get(i));
        }
        resSb.append(" ".repeat(Math.max(0, blk)));
        return resSb.toString();
    }

    public static void main(String[] args) {
        RearrangeSpacesBetweenWords rs = new RearrangeSpacesBetweenWords();
        String s = "  this   is  a sentence ";
        System.out.println(rs.reorderSpaces(s));
    }
}
