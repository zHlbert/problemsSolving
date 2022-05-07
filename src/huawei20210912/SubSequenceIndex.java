package huawei20210912;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubSequenceIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        List<String> inputStrs = new ArrayList<>();
//        while (sc.hasNext()) {
//            inputStrs.add(sc.next());
//        }
//        if (inputStrs.size() != 2) {
//            System.out.println(-1);
//            return;
//        }
//        String target = inputStrs.get(0);
//        String source = inputStrs.get(1);
        String target = sc.next();
        String source = sc.next();
        int maxStartIndex = -1;
        if (target.length() > source.length()) {
            System.out.println(maxStartIndex);
            return;
        }
        if (target.length() == source.length()) {
            System.out.println(target.equals(source) ? 0 : maxStartIndex);
            return;
        }
        int indexTarget = 0;
        int currStart = -1;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(indexTarget)) {
                if (indexTarget == 0) {
                    currStart = i;
                }
                if (indexTarget == target.length() - 1) {
                    maxStartIndex = currStart;
                }
                indexTarget = (indexTarget + 1) % target.length();
            }
        }
        System.out.println(maxStartIndex);
    }
}
