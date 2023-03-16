package leetcode._2488;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithMedianK {
//    public int countSubarrays(int[] nums, int k) {
//        int n = nums.length;
//        int ik = 0;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] == k) {
//                ik = i;
//                break;
//            }
//        }
//
//        Map<Integer, Integer>[] cnt = new HashMap[2];
//        cnt[0] = new HashMap<>();
//        cnt[1] = new HashMap<>();
//        int lessThanKCnt = 0, res = 0;
//        for (int i = 0; i < n; i++) {
//            lessThanKCnt += nums[i] < k ? 1 : 0;
//            int key = 2 * lessThanKCnt - i;
////            System.out.println(i + ", " + lessThanKCnt + ", " + key);
//            int odd = i & 1;
//            if (i < ik) {
//                Map<Integer, Integer> cn = cnt[odd];
//                int c = cn.getOrDefault(key, 0);
//                cn.put(key, c + 1);
//            }
//            if (i >= ik) {
//                int c1 = cnt[1 - odd].getOrDefault(key + 1, 0);
//                int c2 = cnt[odd].getOrDefault(key, 0);
////                System.out.println();
//                res = res + c1 + c2;
//            }
//        }
//        System.out.println(cnt[0]);
//        System.out.println(cnt[1]);
//        return res;
//    }
//
//    public int countSubarrays1(int[] nums, int k) {
//        int n = nums.length;
//        int ik = 0;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] == k) {
//                ik = i;
//                break;
//            }
//        }
//        Map<Integer, Integer> cnt = new HashMap<>();
//        int lessThanKCnt = 0, res = 0;
//        for (int i = 0; i < n; i++) {
//            lessThanKCnt += nums[i] < k ? 1 : 0;
//            int key = 2 * lessThanKCnt - i;
//            System.out.println(i + ", " + lessThanKCnt + ", " + key);
//            int odd = i & 1;
//            if (i < ik) {
//                int c = cnt.getOrDefault(key, 0);
//                cnt.put(key, c + 1);
//            }
//            if (i >= ik) {
//                int c1 = cnt.getOrDefault(key + 1, 0);
//                int c2 = cnt.getOrDefault(key, 0);
//                res = res + c1 + c2;
//            }
//        }
//        System.out.println(cnt);
//        return res;
//    }

    /**
     * 哈希 + 前缀和
     * @param nums
     * @param k
     * @return
     */
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int ik = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                ik = i;
                break;
            }
        }
        int res = 0, sum = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += Integer.compare(nums[i], k);
            if (i < ik) {
                cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            } else {
                int pre0 = cnt.getOrDefault(sum, 0);
                int pre1 = cnt.getOrDefault(sum - 1, 0);
                res += pre0 + pre1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountSubarraysWithMedianK cs = new CountSubarraysWithMedianK();
        System.out.println(cs.countSubarrays(new int[] {3,2,1,4,5}, 4));
//        System.out.println(cs.countSubarrays1(new int[] {2,3,1}, 3));
//        System.out.println(cs.countSubarrays1(new int[] {2,5,1,4,3}, 4));
    }
}
