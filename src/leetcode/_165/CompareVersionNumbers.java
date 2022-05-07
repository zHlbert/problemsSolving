package leetcode._165;

/**
 * Given two version numbers, version1 and version2, compare them.
 *
 * Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.
 *
 * To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
 *
 * Return the following:
 *
 * If version1 < version2, return -1.
 * If version1 > version2, return 1.
 * Otherwise, return 0.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-version-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1StrArr = version1.split("\\.");
        String[] v2StrArr = version2.split("\\.");
        int[] v1Arr = new int[v1StrArr.length];
        int[] v2Arr = new int[v2StrArr.length];
        for (int i = 0; i < v1StrArr.length; i++) {
            v1Arr[i] = Integer.parseInt(v1StrArr[i]);
        }
        for (int i = 0; i < v2StrArr.length; i++) {
            v2Arr[i] = Integer.parseInt(v2StrArr[i]);
        }
        int res = 0;
        int c = 0;
        while (c < v1Arr.length || c < v2Arr.length) {
            Integer i1 = c < v1Arr.length ? v1Arr[c] : 0;
            Integer i2 = c < v2Arr.length ? v2Arr[c] : 0;
            if (!i1.equals(i2)) {
                res = i1.compareTo(i2);
                break;
            }
            c++;
        }
        return res;
    }

    public static void main(String[] args) {
        CompareVersionNumbers c = new CompareVersionNumbers();
        System.out.println(c.compareVersion("1.01", "1.001"));
//        System.out.println(c.compareVersion("1.0", "1.0.0"));
//        System.out.println(c.compareVersion("0.1", "1.1"));
//        System.out.println(c.compareVersion("1.0.1", "1"));
//        System.out.println(c.compareVersion("7.5.2.4", "7.5.3"));
    }
}
