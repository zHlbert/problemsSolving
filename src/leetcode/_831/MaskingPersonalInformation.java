package leetcode._831;

public class MaskingPersonalInformation {
    public String maskPII(String s) {
        StringBuilder resSb = new StringBuilder();
        if (s.contains("@")) {
            String name = s.substring(0, s.indexOf('@'));
            String domain = s.substring(s.indexOf('@') + 1);
            resSb.append(convertLowerCase(name.charAt(0)));
            resSb.append("*****");
            resSb.append(convertLowerCase(name.charAt(name.length() - 1)));
            resSb.append('@');
            for (char c : domain.toCharArray())
                resSb.append(convertLowerCase(c));
        } else {
            StringBuilder numbers = new StringBuilder();
            for (char c : s.toCharArray())
                if (c >= '0' && c <= '9')
                    numbers.append(c);

            int n = numbers.length();
            String tailNo = numbers.substring(n - 4);

            String front = "+***-";
            if (n == 10) front = "";
            else if (n == 11) front = "+*-";
            else if (n == 12) front = "+**-";
            resSb.append(front).append("***-***-").append(tailNo);
        }
        return resSb.toString();
    }

    private char convertLowerCase(char c) {
        return c >= 'A' && c <= 'Z' ? (char) (c - 'A' + 'a') : c;
    }

    public static void main(String[] args) {
        MaskingPersonalInformation mpi = new MaskingPersonalInformation();
        System.out.println(mpi.maskPII("LeetCode@LeetCode.com"));
        System.out.println(mpi.maskPII("AB@qq.com"));
        System.out.println(mpi.maskPII("1(234)567-890"));
    }
}
