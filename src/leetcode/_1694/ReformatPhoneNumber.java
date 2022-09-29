package leetcode._1694;

import java.util.ArrayList;
import java.util.List;

public class ReformatPhoneNumber {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (c != ' ' && c != '-') {
                sb.append(c);
            }
        }
        List<String> list = new ArrayList<>();
        String s = sb.toString();
        int p = 0, i = 0, n = sb.length();
        while (n - i > 4) {
            i += 3;
            list.add(s.substring(p, i));
            p = i;
        }
        if (n - i == 4) {
            list.add(s.substring(i, i + 2));
            list.add(s.substring(i + 2, n));
        } else {
            list.add(s.substring(i, n));
        }
        return String.join("-", list);
    }
}
