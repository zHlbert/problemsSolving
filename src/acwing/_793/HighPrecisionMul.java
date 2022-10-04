package acwing._793;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HighPrecisionMul {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        int b = Integer.parseInt(reader.readLine());
        List<Integer> al = new ArrayList<>();
        for (int i = a.length() - 1; i >= 0; i--) {
            al.add(a.charAt(i) - '0');
        }
        List<Integer> res = mul(al, b);
        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.print(res.get(i));
        }
    }

    private static List<Integer> mul(List<Integer> al, int b) {
        List<Integer> res = new ArrayList<>();
        if (b == 0) {
            res.add(0);
            return res;
        }
        int t = 0;
        for (int i = 0; i < al.size() || t > 0; i++) {
            if (i < al.size()) t += al.get(i) * b;
            res.add(t % 10);
            t /= 10;
        }
        return res;
    }
}
