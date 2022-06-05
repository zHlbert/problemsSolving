package contest.leetcode20220605;

/**
 * https://leetcode.cn/problems/design-a-text-editor/
 */
public class DesignATextEditor {

}

class TextEditor {

    int cursor;
    StringBuilder strSb;
    public TextEditor() {
        cursor = 0;
        strSb = new StringBuilder();
    }

    public void addText(String text) {
        strSb.insert(cursor, text);
        cursor += text.length();
    }

    public int deleteText(int k) {
        int newCursor = Math.max(0, cursor - k);
        int deleted = cursor - newCursor;
        strSb.delete(newCursor, cursor);
        cursor = newCursor;
        return deleted;
    }

    public String cursorLeft(int k) {
        cursor = Math.max(cursor - k, 0);
        String subStr = cursor > 10 ? strSb.substring(cursor - 10, cursor) : strSb.substring(0, cursor);
        return subStr;
    }

    public String cursorRight(int k) {
        cursor = Math.min(cursor + k, strSb.length());
        String subStr = cursor > 10 ? strSb.substring(cursor - 10, cursor) : strSb.substring(0, cursor);
        return subStr;
    }
}
