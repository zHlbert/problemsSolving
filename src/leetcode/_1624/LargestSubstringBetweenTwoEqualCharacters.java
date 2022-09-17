package leetcode._1624;

import java.util.Arrays;

public class LargestSubstringBetweenTwoEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        char[] sc = s.toCharArray();
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        int maxL = -1;
        for (int i = 0; i < sc.length; i++) {
            int idx = sc[i] - 'a';
            if (pos[idx] < 0)
                pos[idx] = i;
            else
                maxL = Math.max(maxL, i - pos[idx] - 1);
        }
        return maxL;
    }

    public static void main(String[] args) {
        LargestSubstringBetweenTwoEqualCharacters ls = new LargestSubstringBetweenTwoEqualCharacters();
        System.out.println(ls.maxLengthBetweenEqualCharacters("aa"));
        System.out.println(ls.maxLengthBetweenEqualCharacters("abca"));
        System.out.println(ls.maxLengthBetweenEqualCharacters("cbzxy"));
        System.out.println(ls.maxLengthBetweenEqualCharacters("mgntdygtxrvxjnwksqhxuxtrv"));
    }
}
