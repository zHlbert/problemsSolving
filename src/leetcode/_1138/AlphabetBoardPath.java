package leetcode._1138;

public class AlphabetBoardPath {
    public String alphabetBoardPath(String target) {
        char[] t = target.toCharArray();
        int r = 0, c = 0;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int n = t.length;
        while (i < n) {
            int idx = t[i] - 'a';
            int nr = idx / 5, nc = idx % 5;
            if (nr == 5 && r != 5 && c != 0)
                sb.append("D".repeat(4 - r));
            else
                sb.append((nr > r ? "D" : "U").repeat(Math.abs(nr - r)));
            sb.append((nc > c ? "R" : "L").repeat(Math.abs(nc - c)));
            if (nr == 5 && r != 5 && c != 0)
                sb.append('D');
            sb.append('!');
            r = nr;
            c = nc;
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AlphabetBoardPath abp = new AlphabetBoardPath();
        System.out.println(abp.alphabetBoardPath("leet"));
        System.out.println(abp.alphabetBoardPath("code"));
        System.out.println(abp.alphabetBoardPath("aaaa"));
        System.out.println(abp.alphabetBoardPath("zdz"));
    }
}
