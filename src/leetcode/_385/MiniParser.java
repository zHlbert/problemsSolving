package leetcode._385;

import java.util.List;
import java.util.Stack;

public class MiniParser {
//    public NestedInteger deserialize(String s) {
//        StringBuilder currValueBuilder;
//        NestedInteger currN = null;
//
//        Stack<Character> charStack = new Stack<>();
//        for (char c : s.toCharArray()) {
//            if (c != ']') {
//                charStack.push(c);
//            } else {
//                currValueBuilder = new StringBuilder();
//                while (!charStack.empty()) {
//                    char pop = charStack.pop();
//                    if (Character.isDigit(pop) || pop == '-' || pop == ',') {
//                        currValueBuilder.insert(0, pop);
//                    }
//                    if (pop == '[') {
//                        if (currN == null) {
//                            currN = convert2NestedInteger(currValueBuilder.toString());
//                        } else {
//                            NestedInteger nestedInteger = new NestedInteger();
//                            String currValue = currValueBuilder.toString();
//                            if (!currValue.equals("")) {
//                                nestedInteger.add(convert2NestedInteger(currValue));
//                            } else {
//                                nestedInteger.add(new NestedInteger());
//                            }
//                            if (currN.isInteger()) {
//                                NestedInteger tmpNi = new NestedInteger();
//                                tmpNi.add(currN);
//                                nestedInteger.add(tmpNi);
//                            } else {
//                                nestedInteger.add(currN);
//                            }
//                            currN = nestedInteger;
//                        }
//                        break;
//                    }
//                }
//            }
//        }
//        if (currN == null) {
//            currValueBuilder = new StringBuilder();
//            while (!charStack.empty()) {
//                Character pop = charStack.pop();
//                currValueBuilder.insert(0, pop);
//            }
//            return convert2NestedInteger(currValueBuilder.toString());
//        }
//        return currN;
//    }
//
//    private NestedInteger convert2NestedInteger(String intStr) {
//        String[] split = intStr.split(",");
//        NestedInteger res = new NestedInteger();
//        for (String s : split) {
//            if (s.equals("")) {
//                continue;
//            }
//            NestedInteger ni = new NestedInteger(Integer.parseInt(s));
//            res.add(ni);
//        }
//        return res;
//    }

//"[123,456,[788,799,833],[[]],10,[]]"
}
