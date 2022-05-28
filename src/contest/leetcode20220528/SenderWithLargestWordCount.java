package contest.leetcode20220528;

import java.util.*;

/**
 * https://leetcode.cn/contest/biweekly-contest-79/problems/sender-with-largest-word-count/
 */
public class SenderWithLargestWordCount {
    public String largestWordCount(String[] messages, String[] senders) {
        int n = messages.length;
        Map<String, Integer> senderMsgMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String sender = senders[i];
            String message = messages[i];
            int curMsg = senderMsgMap.getOrDefault(sender, 0);
            senderMsgMap.put(sender, curMsg + message.split(" ").length);
        }
        System.out.println(senderMsgMap);
        List<Map.Entry<String, Integer>> senderMsgList = new ArrayList<>(senderMsgMap.size());
        senderMsgList.addAll(senderMsgMap.entrySet());
        return senderMsgList.stream().min((e1, e2) -> {
            if (e1.getValue().equals(e2.getValue())) {
                return e2.getKey().compareTo(e1.getKey());
            }
            return e2.getValue().compareTo(e1.getValue());
        }).get().getKey();
    }

    public static void main(String[] args) {
        SenderWithLargestWordCount sl = new SenderWithLargestWordCount();
        String[] messages = new String[] {"Hello userTwooo dd","Hi userThree ewe gr we","Wonderful day Alice dd gg","Nice day userThree"};
        String[] senders = new String[] {"Alice","userTwo","userThree","Alice"};
        System.out.println(sl.largestWordCount(messages, senders));
    }
}
