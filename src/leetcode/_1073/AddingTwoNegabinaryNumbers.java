package leetcode._1073;

import java.util.ArrayList;
import java.util.List;

public class AddingTwoNegabinaryNumbers {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1, j = arr2.length - 1;
        int carry = 0;
        List<Integer> res = new ArrayList<>();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = carry;
            if (i >= 0) x += arr1[i];
            if (j >= 0) x += arr2[j];
            if (x >= 2) {
                res.add(x - 2);
                carry = -1;
            } else if (x >= 0) {
                res.add(x);
                carry = 0;
            } else {
                res.add(1);
                carry = 1;
            }
            i--;
            j--;
        }
        while (res.size() > 1 && res.get(res.size() - 1) == 0) {
            res.remove(res.size() - 1);
        }
        int[] arr = new int[res.size()];
        for (i = 0, j = res.size() - 1; j >= 0; i++, j--) {
            arr[i] = res.get(j);
        }
        return arr;
    }
}
