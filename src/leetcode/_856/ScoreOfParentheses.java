package leetcode._856;

import java.util.ArrayDeque;
import java.util.Deque;

public class ScoreOfParentheses {
//    public int scoreOfParentheses(String s) {
//        char[] sc = s.toCharArray();
////        Deque<Character> pth = new ArrayDeque<>();
//        Deque<Integer> ns = new ArrayDeque<>();
//        for (int i = 0; i < sc.length; i++) {
//            char c = sc[i];
//            if (c == '(') {
////                pth.push('(');
//                continue;
//            }
//
//            if (sc[i - 1] == '(') {
//                ns.push(1);
////                if (pth.size() <= 1) {
////                    1ns.push(1);
////                } else {
////                    ns.push(ns.pop() + ns.pop());
////                }
//            } else {
//                ns.push(ns.pop() * 2);
//            }
////            pth.pop();
//        }
//        return ns.peek();
//    }

    /**
     * 栈
     * @param s
     * @return
     */
    public int scoreOfParentheses(String s) {
        char[] sc = s.toCharArray();
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        for (char c : sc) {
            if (c == '(') {
                st.push(0);
            } else {
                int v = st.pop();
                st.push(st.pop() + Math.max(2 * v, 1));
            }
        }
        return st.peek();
    }
}
