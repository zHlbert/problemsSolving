package contest.leetcode20220703;

import java.util.Arrays;

public class DecodeTheMessage {
    public String decodeMessage(String key, String message) {
        int[] dict = new int[26];
        Arrays.fill(dict, -1);
        int i = 0;
        for (char c : key.toCharArray()) {
            if (i < 26 && c >= 'a' && c <= 'z') {
                int idx = c - 'a';
                if (dict[idx] == -1) {
                    dict[idx] = i++;
                }
            }
        }
        char[] m = message.toCharArray();
        for (int j = 0; j < m.length; j++) {
            char c = m[j];
            if (c >= 'a' && c <= 'z') {
                m[j] = (char) (dict[c - 'a'] + 'a');
            }
        }
        return new String(m);
    }

    public static void main(String[] args) {
        DecodeTheMessage cm = new DecodeTheMessage();
//        String key = "the quick brown fox jumps over the lazy dog";
//        String message = "vkbs bs t suepuv";
        String key = "eljuxhpwnyrdgtqkviszcfmabo";
        String message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        System.out.println(cm.decodeMessage(key, message));
    }
}
