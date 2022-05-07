package leetcode._394;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DecodeString {
//    public String decodeString(String s) {
//        StringBuilder sb = new StringBuilder();
//        int i = 0;
//        char[] chars = s.toCharArray();
//        Stack<String> stack = new Stack<>();
//        while (i < chars.length) {
//            while (!Character.isDigit(chars[i])) {
//                sb.append(chars[i]);
//                i++;
//            }
//
//        }
//        return sb.toString();
//    }

    public String decodeString(String s) {
        Stack<Integer> multiStack = new Stack<>();
        Stack<StringBuilder> ansStack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int multi = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))
                multi = multi * 10 + (c - '0');
            else if (Character.isAlphabetic(c))
                ans.append(c);
            else if (c == '[') {
                ansStack.push(ans);
                multiStack.push(multi);
                ans = new StringBuilder();
                multi = 0;
            } else {
                StringBuilder ansTmp = ansStack.pop();
                int tmp = multiStack.pop();
                ansTmp.append(String.valueOf(ans).repeat(Math.max(0, tmp)));
                ans = ansTmp;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        DecodeString d = new DecodeString();
        System.out.println(d.decodeString(s));
    }
}
