package leetcode._2299;

public class StrongPasswordCheckerII {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        char[] pc = password.toCharArray();
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;
        boolean notAdj = true;
        for (int i = 0; i < pc.length; i++) {
            char c = pc[i];
            if (c >= 'a' && c <= 'z') hasLower = true;
            if (c >= 'A' && c <= 'Z') hasUpper = true;
            if (c >= '0' && c <= '9') hasDigit = true;
            if ("!@#$%^&*()-+".contains("" + c)) hasSpecial = true;
            if (i > 0 && c == pc[i - 1]) notAdj = false;
        }
        return hasLower && hasUpper && hasDigit && hasSpecial && notAdj;
    }
}
