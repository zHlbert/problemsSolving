package leetcode._468;

import java.util.*;

public class ValidateIPAddress {
    String[] retStr = {"IPv4", "IPv6", "Neither"};
    Set<Character> ipv6ChSet;
    public String validIPAddress(String queryIP) {
        boolean containsDot = queryIP.contains(".");
        boolean containsColon = queryIP.contains(":");
        if (!containsDot && !containsColon) {
            return retStr[2];
        }
        if (containsDot) {
            return retStr[checkIPv4(queryIP)];
        }
        char[] ipv6Chars = "0123456789abcdefABCDEF".toCharArray();
        ipv6ChSet = new HashSet<>(ipv6Chars.length);
        for (char ch : ipv6Chars) {
            ipv6ChSet.add(ch);
        }
        return retStr[checkIPv6(queryIP)];

    }

    private int checkIPv6(String queryIP) {
        String[] ipArr;
        ipArr = queryIP.split(":", -1);
        if (ipArr.length != 8) {
            return 2;
        }
        for (int i = 0; i < 8; i++) {
            String ipEle = ipArr[i];
            char[] ipChars = ipEle.toCharArray();
            int len = ipChars.length;
            if (len > 4 || len < 1) {
                return 2;
            }
            for (char ipChar : ipChars) {
                if (!ipv6ChSet.contains(ipChar)) {
                    return 2;
                }
            }
        }
        return 1;
    }

    private int checkIPv4(String queryIP) {
        String[] ipArr;
        ipArr = queryIP.split("\\.", -1);
        if (ipArr.length != 4) {
            return 2;
        }
        for (int i = 0; i < 4; i++) {
            String ipEle = ipArr[i];
            char[] ipChars = ipEle.toCharArray();
            int len = ipChars.length;
            if (len > 3 || len < 1) {
                return 2;
            }
            if ((len == 2 || len == 3) && ipChars[0] == '0') {
                return 2;
            }
            for (char ipChar : ipChars) {
                if (!Character.isDigit(ipChar)) {
                    return 2;
                }
            }
            if (len == 3) {
                int ipNum = Integer.parseInt(ipEle);
                if (ipNum > 255) {
                    return 2;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ValidateIPAddress va = new ValidateIPAddress();
//        String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        System.out.println(va.validIPAddress(ip));
    }
}
