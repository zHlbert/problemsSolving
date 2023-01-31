package leetcode._2325;

import java.util.Arrays;

public class DecodeTheMessage {
    public String decodeMessage(String key, String message) {
        int[] kv = new int[26];
        Arrays.fill(kv, -1);
        char[] ky = key.toCharArray();
        for (int i = 0, j = 0; i < ky.length; i++) {
            char c = ky[i];
            if (c != ' ' && j < 26 && kv[c - 'a'] == -1) kv[c - 'a'] = j++;
        }

        int m = message.length();
        char[] ms = message.toCharArray();
        char[] res = new char[m];
        for (int i = 0; i < m; i++) {
            if (ms[i] == ' ') res[i] = ' ';
            else res[i] = (char) ('a' + kv[ms[i] - 'a']);
        }
        return new String(res);
    }

    public static void main(String[] args) {
        DecodeTheMessage dm = new DecodeTheMessage();
        System.out.println(dm.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        System.out.println(dm.decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }
}
