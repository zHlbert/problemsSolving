package acwing._3302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Expression {
    static int N = 100010;

    static char[] opStack = new char[N];

    static int[] numStack = new int[N];

    static int opTop = 0, numTop = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String exp = reader.readLine();
        char[] sc = exp.toCharArray();

        Map<Character, Integer> pr = new HashMap<>();
        pr.put('+', 1);
        pr.put('-', 1);
        pr.put('*', 2);
        pr.put('/', 2);

        int n = sc.length;
        for (int i = 0; i < n; i++) {
            char c = sc[i];
            if (Character.isDigit(c)) {
                int num = 0;
                int j = i;
                while (j < n && Character.isDigit(sc[j])) {
                    num = num * 10 + sc[j++] - '0';
                }
                i = j - 1;
                numStack[++numTop] = num;
            } else {
                if (c == '(') {
                    opStack[++opTop] = c;
                } else if (c == ')') {
                    while (opStack[opTop] != '(') {
                        popCompute();
                    }
                    opTop--;
                } else {
                    while (opTop > 0 && opStack[opTop] != '(' && pr.get(opStack[opTop]) >= pr.get(c)) {
                        popCompute();
                    }
                    opStack[++opTop] = c;
                }
            }
        }

        while (opTop > 0) {
            popCompute();
        }

//        print(numStack, numTop);
        System.out.println(numStack[numTop]);

        reader.close();
    }

    private static void popCompute() {
        char op = opStack[opTop--];
        int x2 = numStack[numTop--];
        int x1 = numStack[numTop--];
        int res;
        if (op == '+') {
            res = x1 + x2;
        } else if (op == '-') {
            res = x1 - x2;
        } else if (op == '*') {
            res = x1 * x2;
        } else {
            res = x1 / x2;
        }
//        System.out.println(x1 + ", " + x2 + ", " + op + ", " + res);
        numStack[++numTop] = res;
    }

    private static void print(int[] numStack, int numTop) {
        int idx = numTop;
        while (idx > 0) {
            System.out.print(numStack[idx] + " ");
            idx--;
        }
        System.out.println();
    }
}
