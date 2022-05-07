package leetcode._821;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String s, char c) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                indexes.add(i);
            }
        }
        int[] ans = new int[s.length()];
        int currIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int occurence = indexes.get(currIndex);
            if (i == occurence && (currIndex + 1 < indexes.size())) {
                currIndex++;
            } else if (i < occurence) {
                int dis2Right = occurence - i;
                int dis2Left = currIndex > 0 ? i - indexes.get(currIndex - 1) : Integer.MAX_VALUE;
                ans[i] = Math.min(dis2Left, dis2Right);
            } else if (i > occurence) {
                ans[i] = i - occurence;
            }
        }
        return ans;
    }

    public int[] shortestToChar1(String s, char c) {
        int first = s.indexOf(c);
        int last = s.lastIndexOf(c);
        int prev = -1;
        int idx = first;
        char[] chars = s.toCharArray();
        int[] ans = new int[s.length()];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                prev = idx;
                if (idx != last) {
                    idx = s.indexOf(c, idx + 1);
                }
            }
            if (i <= first) {
                ans[i] = first - i;
            } else if (i <= last) {
                ans[i] = Math.min(i - prev, idx - i);
            } else {
                ans[i] = i - last;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ShortestDistanceToACharacter sh = new ShortestDistanceToACharacter();
        String s = "loveleetcode";
        char c = 'e';
        ArrayUtils.printArray(sh.shortestToChar1(s, c));
    }
}
