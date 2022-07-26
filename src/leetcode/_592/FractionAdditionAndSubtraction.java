package leetcode._592;

public class FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        Integer numer = null, denom = null;
        int cn = 0, cd = 0;
        boolean cPos = true, cNum = true;
        expression = expression + '$';
        char[] chars = expression.toCharArray();
        for (char c : chars) {
            if (c == '-' || c == '+' || c == '$') {
                if (denom == null && cd != 0) {
                    numer = cPos ? cn : -cn;
                    denom = cd;
                } else if (cd != 0) {
                    int gcd = getGcd(denom, cd);
                    int lcm = denom * cd / gcd;
                    numer = lcm / denom * numer + lcm / cd * (cPos ? cn : -cn);
                    denom = lcm;
                }
                cd = 0;
                cn = 0;
                cPos = c != '-';
                cNum = true;
            } else if (Character.isDigit(c)) {
                if (cNum) {
                    cn = cn * 10 + (c - '0');
                } else {
                    cd = cd * 10 + (c - '0');
                }
            } else if (c == '/') {
                cNum = false;
            }
        }
        int gcd = getGcd(Math.abs(numer), denom);
        numer = numer / gcd;
        denom = denom / gcd;
        return String.valueOf(numer) + '/' + denom;
    }

    private int getGcd(int a, int b) {
        return b != 0 ? getGcd(b, a % b) : a;
    }

    public static void main(String[] args) {
        FractionAdditionAndSubtraction fas = new FractionAdditionAndSubtraction();
        System.out.println(fas.fractionAddition("-1/2+1/2"));
        System.out.println(fas.fractionAddition("-1/2+1/2+1/3"));
        System.out.println(fas.fractionAddition("1/3-1/2"));
    }
}
