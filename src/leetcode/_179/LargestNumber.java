package leetcode._179;

import java.util.*;
import java.util.function.Function;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<Integer> numList = new ArrayList<>(nums.length);
        for (int num : nums) {
            numList.add(num);
        }
        Integer[] numArr = numList.toArray(new Integer[0]);
        Arrays.sort(numArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });
//        numList.sort((x, y) -> {
////            String xStr = String.valueOf(x);
////            String yStr = String.valueOf(y);
////            return (yStr + xStr).compareTo(xStr + yStr);
//            long sx = 10, sy = 10;
//            while (sx <= x) {
//                sx *= 10;
//            }
//            while (sy <= y) {
//                sy *= 10;
//            }
//            return (int) (-sy * x - y + sx * y + x);
//        });
        if (numArr[0] == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (Integer s : numArr) res.append(s);
        return res.toString();
    }

    public String largestNumber1(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        System.out.println(ln.largestNumber(new int[] {0,9,8,7,6,5,4,3,2,1}));
//        System.out.println(a > b);
    }
}
