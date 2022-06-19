package contest.leetcode20220619;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SumOfNumbersWithUnitsDigitK {
    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
//        if (k == 0) {
//            return -1;
//        }
//        List<Integer> numList = new ArrayList<>();
//        int cur = k;
//        while (cur <= num) {
//            numList.add(cur);
//            cur += 10;
//        }

//        int remains = num;
//        int res = 0;
//        while (remains > 0) {
//            if (remains < 10) {
//                if (remains != k) {
//                    return -1;
//                }
//            }
//            int lDigit = remains % 10;
//            if (lDigit == k) {
//                res++;
//                break;
//            } else {
//                int major = remains - lDigit;
//                if (lDigit > k) {
//                    remains -= major + k;
//                } else {
//                    remains -= (major - 10 + k);
//                }
//                res++;
//            }
//        }

        int sum = 0, res = 0;
        while (sum <= num) {
            if (sum != 0 && sum % 10 == num % 10) {
                return res;
            }
            sum += k != 0 ? k : 10;
            res++;
        }

        return -1;
    }

    public static void main(String[] args) {
        SumOfNumbersWithUnitsDigitK sn = new SumOfNumbersWithUnitsDigitK();
        System.out.println(sn.minimumNumbers(58,9));
        System.out.println(sn.minimumNumbers(37,2));
        System.out.println(sn.minimumNumbers(0,7));
        System.out.println(sn.minimumNumbers(73,1));
        System.out.println(sn.minimumNumbers(10,0));
    }
}
