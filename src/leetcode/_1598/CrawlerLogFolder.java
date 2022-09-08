package leetcode._1598;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int top = 0;
        for (String log : logs) {
            if (log.equals("./")) {
                continue;
            }
            if (log.equals("../")) {
                top = Math.max(0, top - 1);
            } else {
                top++;
            }
        }
        return top;
    }
}
