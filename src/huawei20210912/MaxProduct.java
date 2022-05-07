package huawei20210912;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxProduct {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String strs = sc.next();
        String[] strArr = strs.split(",");

        int maxProduct = 0;
        for (int i = 0; i < strArr.length; i++) {
            for (int j = i + 1; j < strArr.length; j++) {
                String si = strArr[i];
                String sj = strArr[j];
                boolean hasSameChar = false;
                for (int k = 0; k < sj.length(); k++) {
                    if (si.contains("" + sj.charAt(k))) {
                        hasSameChar = true;
                        break;
                    }
                }
                if (!hasSameChar) {
                    maxProduct = Math.max(maxProduct, si.length() * sj.length());
                }
            }
        }
        System.out.println(maxProduct);
    }
}
