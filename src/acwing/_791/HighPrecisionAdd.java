package acwing._791;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class HighPrecisionAdd {
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
        List<Integer> res = add(al, bl);
        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.print(res.get(i));
        }
    }

    private static List<Integer> add(List<Integer> al, List<Integer> bl) {
        List<Integer> res = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < al.size() || i < bl.size(); i++) {
            if (i < al.size()) t += al.get(i);
            if (i < bl.size()) t += bl.get(i);
            res.add(t % 10);
            t /= 10;
        }
        if (t > 0) {
            res.add(1);
        }
        return res;
    }
}
