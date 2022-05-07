package leetcode._388;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-absolute-file-path/
 */
public class LongestAbsoluteFilePath {
    public int longestPath = 0;

    public int lengthLongestPath(String input) {
        if (input.length() < 3 || !input.startsWith("dir")) {
            return longestPath;
        }
        return splitPath(input, "\n\t", 0);
    }

    private int splitPath(String str, String delimeter, int length) {
        if (!str.contains(delimeter)) {
            return length + str.length();
        }
        String[] split = str.split(delimeter);
        longestPath += split[0].length();
        for (int i = 1; i < split.length; i++) {
            longestPath = Math.max(longestPath, splitPath(split[i], delimeter + "\t", length + 1));
        }

        return longestPath;
    }

    public int lengthLongestPathHash(String input) {
        // 每个深度的路径长度
        Map<Integer, Integer> depthLengthMap = new HashMap<>();
        depthLengthMap.put(-1, 0);
        int ans = 0;
        String[] split = input.split("\n");
        for (String line : split) {
            int depth = countCharInStr(line, '\t');
            // 长度去掉 '\t'
            depthLengthMap.put(depth, depthLengthMap.get(depth - 1) + line.length() - depth);
            if (line.contains(".")) {
                // 长度加上 '/'
                ans = Math.max(ans, depthLengthMap.get(depth) + depth);
            }
        }
        return ans;
    }

    private int countCharInStr(String line, char c) {
        int ans = 0;
        for (char ch : line.toCharArray()) {
            if (ch == c) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestAbsoluteFilePath lon = new LongestAbsoluteFilePath();
        String s = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(lon.lengthLongestPathHash(s));
//        String[] strs = s.split("\\\\n\\\\t");
//        for (String str : strs) {
//            System.out.println("str: " + str);
//        }
//        System.out.println("s: " + s);
//        String[] strs = new String[] {"\\n\\t", "\\n\\tsub", "\\t"};
//        for (String str : strs) {
//            System.out.println(str + ": " + str.length());
//        }
    }
}
