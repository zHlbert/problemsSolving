package leetcode._386;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrderIteration(int n) {
        List<Integer> res = new ArrayList<>(n);
        int curr = 1;
        for (int i = 0; i < n; i++) {
            res.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                while (curr % 10 == 9 || curr + 1 > n) {
                    curr /= 10;
                }
                curr++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LexicographicalNumbers lex = new LexicographicalNumbers();
        System.out.println(lex.lexicalOrderIteration(13));
        System.out.println(lex.lexicalOrderIteration(2));
        System.out.println(lex.lexicalOrderIteration(24));
        System.out.println(lex.lexicalOrderIteration(147));
    }
}
