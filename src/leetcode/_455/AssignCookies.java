package leetcode._455;

import java.util.Arrays;

/**
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
 *
 * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/assign-cookies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int index = 0;
        for (int cookie : s) {
            if (index < g.length && cookie >= g[index]) {
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        AssignCookies a = new AssignCookies();
        int[] g = new int[] {10,9,8,7};
        int[] s = new int[] {5,6,7,8};
        System.out.println(a.findContentChildren(g, s));
    }
}
