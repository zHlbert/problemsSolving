package leetcode._1678;

public class GoalParserInterpretation {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        char[] sc = command.toCharArray();
        int idx = 0, n = sc.length;
        while (idx < n) {
            if (sc[idx] == 'G') {
                sb.append('G');
                idx++;
            } else if (sc[idx + 1] == ')') {
                sb.append('o');
                idx += 2;
            } else {
                sb.append("al");
                idx += 4;
            }
        }
        return sb.toString();
    }
}
