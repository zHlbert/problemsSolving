package leetcode._1224;

import java.util.HashMap;
import java.util.Map;

public class MaximumEqualFrequency {
//    public int maxEqualFreq(int[] nums) {
//        int mx = 0, mn = Integer.MAX_VALUE, res = 1;
//        int mxi = 0, mni = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int cnt = map.getOrDefault(nums[i], 0);
//            map.put(nums[i], ++cnt);
//            if (cnt > mx) {
//                mx = cnt;
//                mxi = nums[i];
//            }
//            if (mxi != nums[i]) {
//                mn = Math.min(mn, cnt);
//            } else {
//                mn = mx;
//            }
//            int m = map.size();
//            if (mn * m + 1 == i + 1 || mn == 1 && mx * (m - 1) + 1 == i + 1) {
//                res = i + 1;
//            }
//        }
//        return res;
//    }

    /**
     * 哈希表
     * @param nums
     * @return
     */
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int res = 0, maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt.getOrDefault(nums[i], 0) > 0) {
                freq.put(cnt.get(nums[i]), freq.get(cnt.get(nums[i])) - 1);
            }
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            maxFreq = Math.max(maxFreq, cnt.get(nums[i]));
            freq.put(cnt.get(nums[i]), freq.getOrDefault(cnt.get(nums[i]), 0) + 1);
            boolean ok = maxFreq == 1
                    || freq.get(maxFreq) * maxFreq + freq.get(maxFreq - 1) * (maxFreq - 1) == i + 1
                        && freq.get(maxFreq) == 1
                    || freq.get(maxFreq) * maxFreq + 1 == i + 1 && freq.get(1) == 1;
            if (ok) {
                res = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumEqualFrequency mef = new MaximumEqualFrequency();
//        int[] nums = new int[] {2,2,1,1,5,3,3,5};
        int[] nums = new int[] {1,1,1,2,2,2};
        System.out.println(mef.maxEqualFreq(nums));
    }
}
