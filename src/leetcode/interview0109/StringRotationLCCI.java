package leetcode.interview0109;

/**
 * https://leetcode.cn/problems/string-rotation-lcci/
 */
public class StringRotationLCCI {
    /**
     * 字符串匹配
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        if (n == 0) {
            return true;
        }

        String ns = s2 + s2;
        return ns.contains(s1);
    }
}
