package leetcode._722;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    // TODO: 2023/8/3 有问题
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean inBlockComment = false;
        int idx;
        StringBuilder tempSb = new StringBuilder();
        for (String str : source) {
            if (str.contains("/*")) {
                inBlockComment = true;
                idx = str.indexOf("/*");
                if (idx > 0) {
                    tempSb = new StringBuilder(str.substring(0, idx));
                }
                if (str.contains("*/") && !str.contains("/*/")) {
                    if (str.indexOf("*/") < str.length() - 2) {
                        tempSb.append(str.substring(str.indexOf("*/") + 2));
                    }
                    inBlockComment = false;
                    if (tempSb.length() > 0)
                        res.add(tempSb.toString());
                }
            } else if (str.contains("*/") && !str.contains("/*/")) {
                idx = str.indexOf("*/");
                int len = str.length();
                if (idx < len - 2) {
                    tempSb.append(str.substring(idx + 2));
                }
                inBlockComment = false;
                if (tempSb.length() > 0)
                    res.add(tempSb.toString());
            } else if (str.contains("//")) {
                idx = str.indexOf("//");
                if (idx > 0) {
                    res.add(str.substring(0, idx));
                }
            } else if (!inBlockComment) {
                res.add(str);
            }
        }
        return res;
    }

    public List<String> removeComments1(String[] source) {
        List<String> res = new ArrayList<String>();
        StringBuilder newLine = new StringBuilder();
        boolean inBlock = false;
        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                if (inBlock) {
                    if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        inBlock = false;
                        i++;
                    }
                } else {
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        inBlock = true;
                        i++;
                    } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        break;
                    } else {
                        newLine.append(line.charAt(i));
                    }
                }
            }
            if (!inBlock && newLine.length() > 0) {
                res.add(newLine.toString());
                newLine.setLength(0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RemoveComments rc = new RemoveComments();
        System.out.println(rc.removeComments(new String[]{"/*Test program */", "int main()",
                "{ ", "  // variable declaration ", "int a, b, c;",
                "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"}));
        System.out.println(rc.removeComments(new String[] {"a/*comment", "line", "more_comment*/b"}));
    }
}
