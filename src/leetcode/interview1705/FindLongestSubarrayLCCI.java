package leetcode.interview1705;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindLongestSubarrayLCCI {
    /**
     * 哈希 + 前缀和
     * @param array
     * @return
     */
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        char[] sc = new char[n];
        for (int i = 0; i < n; i++) {
            sc[i] = array[i].charAt(0);
        }

        int cn = 0, maxLength = 0;
        int l = -1, r = -1;
        Map<Integer, Integer> idx = new HashMap<>();
        idx.put(0, -1);
        for (int i = 0; i < n; i++) {
            cn += Character.isLetter(sc[i]) ? 1 : -1;
            if (!idx.containsKey(cn)) idx.put(cn, i);
            else if (i - idx.get(cn) > maxLength) {
                maxLength = i - idx.get(cn);
                l = idx.get(cn) + 1;
                r = i;
            }
        }
        if (maxLength == 0) return new String[0];
        String[] res = new String[maxLength];
        for (int i = l, j = 0; i <= r; i++, j++) {
            res[j] = array[i];
        }
        return res;
    }

    public static void main(String[] args) {
        FindLongestSubarrayLCCI fls = new FindLongestSubarrayLCCI();
//        String[] strs = new String[] {"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
//        System.out.println(Arrays.toString(fls.findLongestSubarray(strs)));
        String[] strs = new String[] {"A", "A"};
        System.out.println(Arrays.toString(fls.findLongestSubarray(strs)));
    }
}
