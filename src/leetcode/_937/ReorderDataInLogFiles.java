package leetcode._937;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reorder-data-in-log-files/
 */
public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        List<Log> logList = new ArrayList<>(logs.length);
        List<Log> digitLogList = new ArrayList<>(logs.length);
        for (String log : logs) {
            int index = log.indexOf(" ");
            String contents = log.substring(index);
            String id = log.substring(0, index);
            Log logObj = new Log(id, contents);
            if (Character.isDigit(contents.charAt(1))) {
                digitLogList.add(logObj);
            } else {
                logList.add(logObj);
            }
        }
        logList.sort(Comparator.comparing(Log::getContents).thenComparing(Log::getIdentifier));
        logList.addAll(digitLogList);
        String[] res = new String[logs.length];
        for (int i = 0; i < logList.size(); i++) {
            Log log = logList.get(i);
            res[i] = log.identifier + log.contents;
        }
        return res;
    }
}

class Log {
    String identifier;
    String contents;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Log() {
    }

    public Log(String identifier, String contents) {
        this.identifier = identifier;
        this.contents = contents;
    }
}
