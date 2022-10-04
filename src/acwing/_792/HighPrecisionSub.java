package acwing._792;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HighPrecisionSub {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        List<Integer> al = new ArrayList<>(), bl = new ArrayList<>();
        for (int i = a.length() - 1; i >= 0; i--) {
            al.add(a.charAt(i) - '0');
        }
        for (int i = b.length() - 1; i >= 0; i--) {
            bl.add(b.charAt(i) - '0');
        }

        if (cmp(al, bl)) {
            List<Integer> res = sub(al, bl);
            for (int i = res.size() - 1; i >= 0; i--) {
                System.out.print(res.get(i));
            }
        } else {
            List<Integer> res = sub(bl, al);
            System.out.print('-');
            for (int i = res.size() - 1; i >= 0; i--) {
                System.out.print(res.get(i));
            }
        }
    }

    /**
     * 判断是否 al >= bl
     * @param al
     * @param bl
     * @return
     */
    private static boolean cmp(List<Integer> al, List<Integer> bl) {
        if (al.size() != bl.size()) {
            return al.size() > bl.size();
        }
        for (int i = al.size() - 1; i >= 0; i--) {
            if (!al.get(i).equals(bl.get(i))) {
                return al.get(i) > bl.get(i);
            }
        }
        return true;
    }

    private static List<Integer> sub(List<Integer> al, List<Integer> bl) {
        List<Integer> res = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < al.size() ; i++) {
            t = al.get(i) - t;
            if (i < bl.size()) t -= bl.get(i);
            res.add((t + 10) % 10);
            t = t < 0 ? 1 : 0;
        }

        // 去除前导0
        while (res.size() > 1 && res.get(res.size() - 1) == 0) {
            res.remove(res.size() - 1);
        }

        return res;
    }
}
