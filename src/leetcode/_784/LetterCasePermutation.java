package leetcode._784;

import utils.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCasePermutation {

    /**
     * BFS
     * @param s
     * @return
     */
    public List<String> letterCasePermutation(String s) {
        int n = s.length();
        Pair<String, Integer>[] q = new Pair[100010];
        System.out.println(q.length);
        int head = 0, tail = -1;
        q[++tail] = new Pair<>(s, 0);
        Set<String> res = new HashSet<>();
        res.add(s);
        while (tail >= head) {
            Pair<String, Integer> p = q[head++];
            String ss = p.getKey();
            int i = p.getValue();
            char[] sc = ss.toCharArray();
            while (i < n && !Character.isLetter(sc[i])) {
                i++;
            }

            if (i >= n) {
                continue;
            }
            String s1 = new String(sc);
            q[++tail] = new Pair<>(s1, i + 1);
            res.add(s1);
//            System.out.println(i + ": " + s1);
            sc[i] = (char) (Character.isLowerCase(sc[i]) ? sc[i] - 'a' + 'A' : sc[i] - 'A' + 'a');
            String s2 = new String(sc);
//            System.out.println(i + ": " + s2);
            q[++tail] = new Pair<>(s2, i + 1);
            res.add(s2);
        }
        return new ArrayList<>(res);
    }

    public List<String> letterCasePermutation1(String s) {
        List<String> res = new ArrayList<>();
        char[] sc = s.toCharArray();
        dfs(res, sc, 0);
        return res;
    }

    private void dfs(List<String> res, char[] sc, int start) {
        res.add(String.valueOf(sc));
        for (int i = start; i < sc.length; i++) {
            if (sc[i] >= '0' && sc[i] <= '9') {
                continue;
            }
            sc[i] = (char) (Character.isLowerCase(sc[i]) ? sc[i] - 'a' + 'A' : sc[i] - 'A' + 'a');
            dfs(res, sc, i + 1);
            sc[i] = (char) (Character.isLowerCase(sc[i]) ? sc[i] - 'a' + 'A' : sc[i] - 'A' + 'a');
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation lcp = new LetterCasePermutation();
        System.out.println(lcp.letterCasePermutation1("a1b2"));
        System.out.println(lcp.letterCasePermutation1("3z4"));
        System.out.println(lcp.letterCasePermutation1("12345"));
    }
}
