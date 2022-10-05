package acwing._794;

import utils.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HighPrecisionDiv {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        int b = Integer.parseInt(reader.readLine());
        List<Integer> al = new ArrayList<>();
        for (int i = a.length() - 1; i >= 0; i--) {
            al.add(a.charAt(i) - '0');
        }
        Pair<List<Integer>, Integer> pair = div(al, b);
        List<Integer> res = pair.getKey();
        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.print(res.get(i));
        }
        System.out.println();
        System.out.print(pair.getValue());
    }

    private static Pair<List<Integer>, Integer> div(List<Integer> al, int b) {
        int r = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = al.size() - 1; i >= 0; i--) {
            r = 10 * r + al.get(i);
            res.add(r / b);
            r %= b;
        }

        // 以上计算完高位在前
        reverse(res);

        // 去除前导0
        while (res.size() > 1 && res.get(res.size() - 1) == 0) {
            res.remove(res.size() - 1);
        }
        return new Pair<>(res, r);
    }

    private static void reverse(List<Integer> list) {
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            int t = list.get(i);
            list.set(i, list.get(j));
            list.set(j, t);
        }
    }
}
