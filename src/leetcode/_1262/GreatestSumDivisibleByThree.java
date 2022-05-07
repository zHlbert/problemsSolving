package leetcode._1262;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array nums of integers, we need to find the maximum possible sum of elements of the array such that it is divisible by three.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/greatest-sum-divisible-by-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GreatestSumDivisibleByThree {
//    public int maxSumDivThree(int[] nums) {
//        List<Integer> res0 = new ArrayList<>(nums.length);
//        List<Integer> res1 = new ArrayList<>(nums.length);
//        List<Integer> res2 = new ArrayList<>(nums.length);
//        Arrays.sort(nums);
//        for (int i = nums.length - 1; i >= 0 ; i--) {
//            if (nums[i] % 3 == 0) {
//                res0.add(nums[i]);
//            } else if (nums[i] % 3 == 1) {
//                res1.add(nums[i]);
//            } else {
//                res2.add(nums[i]);
//            }
//        }
//        int sum = 0;
//        int i1 = 0, i2 = 0;
//        while (i1 < res1.size() || i2 < res2.size()) {
//            if (i1 >= res1.size()) {
//                while (i2 + 2 < res2.size()) {
//                    sum += res2.get(i2) + res2.get(i2 + 1) + res2.get(i2 + 2);
//                    i2 += 3;
//                }
//                break;
//            } else if (i2 >= res2.size()) {
//                while (i1 + 2 < res1.size()) {
//                    sum += res1.get(i1) + res1.get(i1 + 1) + res1.get(i1 + 2);
//                    i1 += 3;
//                }
//                break;
//            } else {
//                int sum12 = res1.get(i1) + res2.get(i2);
//                int sum111 = i1 + 2 < res1.size() ? res1.get(i1) + res1.get(i1 + 1) + res1.get(i1 + 2) : 0;
//                int sum222 = i2 + 2 < res2.size() ? res2.get(i2) + res2.get(i2 + 1) + res2.get(i2 + 2) : 0;
//                if (sum12 >= sum111 && sum12 >= sum222) {
//                    sum += sum12;
//                    i1++;
//                    i2++;
//                } else if (sum111 >= sum12 && sum111 >= sum222) {
//                    sum += sum111;
//                    i1 += 3;
//                } else {
//                    sum += sum222;
//                    i2 += 3;
//                }
////                while (i1 < res1.size() && i2 < res2.size()) {
////                    sum += res1.get(i1++) + res2.get(i2++);
////                }
//            }
//        }
////        while (i1 < res1.size() && i2 < res2.size()) {
////            sum += res1.get(i1++) + res2.get(i2++);
////        }
////        while (i1 + 2 < res1.size()) {
////            sum += res1.get(i1) + res1.get(i1 + 1) + res1.get(i1 + 2);
////            i1 += 3;
////        }
////        while (i2 + 2 < res2.size()) {
////            sum += res2.get(i2) + res2.get(i2 + 1) + res2.get(i2 + 2);
////            i2 += 3;
////        }
//        for (Integer n0 : res0) {
//            sum += n0;
//        }
//        return sum;
//    }

    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 3 == 0) {
            return sum;
        }
        List<Integer> res1 = new ArrayList<>(nums.length);
        List<Integer> res2 = new ArrayList<>(nums.length);
//        Arrays.sort(nums);
        for (int j : nums) {
            if (j % 3 == 1) {
                res1.add(j);
            } else if (j % 3 == 2) {
                res2.add(j);
            }
        }
        res1.sort(Comparator.comparingInt(t -> t));
        res2.sort(Comparator.comparingInt(t -> t));
        int res = (res1.size() + res2.size() * 2) % 3;
        int sum1, sum2;
        if (res == 1) {
            sum1 = res1.size() > 0 ? res1.get(0) : 0;
            sum2 = res2.size() > 1 ? res2.get(0) + res2.get(1) : 0;
        } else {
            sum1 = res1.size() > 1 ? res1.get(0) + res1.get(1) : 0;
            sum2 = res2.size() > 0 ? res2.get(0) : 0;
        }
        return sum1 != 0 && sum2 != 0 ? sum - Math.min(sum1, sum2) : sum - Math.max(sum1, sum2);
    }

    public int maxSumDivThreeDP(int[] nums) {
        int[] remainder = new int[3];
        for (int num : nums) {
            int a = remainder[0] + num;
            int b = remainder[1] + num;
            int c = remainder[2] + num;
            remainder[a % 3] = Math.max(remainder[a % 3], a);
            remainder[b % 3] = Math.max(remainder[b % 3], b);
            remainder[c % 3] = Math.max(remainder[c % 3], c);
        }
        return remainder[0];
    }

    public static void main(String[] args) {
        GreatestSumDivisibleByThree g = new GreatestSumDivisibleByThree();
        int[] nums = {366, 809, 6, 792, 822, 181, 210, 588, 344
                , 618, 341, 410, 121, 864, 191, 749, 637, 169
                , 123, 472, 358, 908, 235, 914, 322, 946, 738
                , 754, 908, 272, 267, 326, 587, 267, 803, 281
                , 586, 707, 94, 627, 724, 469, 568, 57, 103
                , 984, 787, 552, 14, 545, 866, 494, 263, 157
                , 479, 823, 835, 100, 495, 773, 729, 921, 348
                , 871, 91, 386, 183, 979, 716, 806, 639, 290
                , 612, 322, 289, 910, 484, 300, 195, 546, 499, 213
                , 8, 623, 490, 473, 603, 721, 793, 418, 551
                , 331, 598, 670, 960, 483, 154, 317, 834, 352};
//        int[] nums = new int[] {3,6,5,1,8};
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        System.out.println(sum);
        System.out.println(g.maxSumDivThreeDP(nums));
    }
}
