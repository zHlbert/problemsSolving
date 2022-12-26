package leetcode._2027;

public class MinimumMovesToConvertString {
    public int minimumMoves(String s) {
        char[] sc = s.toCharArray();
        int i = 0, res = 0;
        while (i < sc.length) {
            while (i < sc.length && sc[i] != 'X')
                i++;
            if (i == sc.length)
                break;
            res++;
            i += 3;
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumMovesToConvertString mm = new MinimumMovesToConvertString();
        System.out.println(mm.minimumMoves("XXOX"));
        System.out.println(mm.minimumMoves("XXXOOXXX"));
    }
}
