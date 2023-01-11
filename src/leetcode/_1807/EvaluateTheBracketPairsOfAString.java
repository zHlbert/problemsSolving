package leetcode._1807;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateTheBracketPairsOfAString {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> knows = new HashMap<>();
        for (List<String> kw : knowledge)
            knows.put(kw.get(0), kw.get(1));

        char[] sc = s.toCharArray();
        int i = 0, n = sc.length;
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            while (i < n && sc[i] != '(')
                sb.append(sc[i++]);
            if (i < n && sc[i] == '(') {
                i++;
                StringBuilder ks = new StringBuilder();
                while (sc[i] != ')')
                    ks.append(sc[i++]);
                sb.append(knows.getOrDefault(ks.toString(), "?"));
                i++;
            }
        }
        return sb.toString();
    }
}
