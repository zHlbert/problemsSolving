package leetcode._385;

import java.util.ArrayDeque;
import java.util.Deque;

public class MiniParserSolution {
//    public NestedInteger deserialize(String s) {
//        if (s.charAt(0) != '[') {
//            return new NestedInteger(Integer.parseInt(s));
//        }
//        Deque<NestedInteger> stack = new ArrayDeque<>();
//        int num = 0;
//        boolean negative = false;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '-') {
//                negative = true;
//            } else if (Character.isDigit(c)) {
//                num = num * 10 + c - '0';
//            } else if (c == '[') {
//                stack.push(new NestedInteger());
//            } else if (c == ',' || c == ']') {
//                if (Character.isDigit(s.charAt(i - 1))) {
//                    stack.peek().add(new NestedInteger(negative ? - num : num));
//                }
//                num = 0;
//                negative = false;
//                if (c == ']' && stack.size() > 1) {
//                    NestedInteger pop = stack.pop();
//                    stack.peek().add(pop);
//                }
//            }
//        }
//        return stack.pop();
//    }
}
