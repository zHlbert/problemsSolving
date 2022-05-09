package leetcode._168;

/**
 * https://leetcode.cn/problems/excel-sheet-column-title/
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int cur = columnNumber;
        while (cur >= 1) {
            int res = (cur - 1) % 26;
            sb.insert(0, (char) (res + 'A'));
            cur = (cur - 1) / 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle es = new ExcelSheetColumnTitle();
        int columnNumber = 52;
//        int columnNumber = 828;
        System.out.println(es.convertToTitle(columnNumber));
    }
}
