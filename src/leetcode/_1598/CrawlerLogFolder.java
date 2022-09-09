package leetcode._1598;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int top = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                top = Math.max(0, top - 1);
            } else if (!log.equals("./")) {
                top++;
            }
        }
        return top;
    }

    public static void main(String[] args) {
        CrawlerLogFolder clf = new CrawlerLogFolder();
        String[] logs = {"d2/", "./", "f4/", "./", "../", "3/"};
        System.out.println(clf.minOperations(logs));
    }
}
