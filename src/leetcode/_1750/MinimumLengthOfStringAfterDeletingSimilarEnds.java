package leetcode._1750;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {
    /**
     * 双指针
     * @param s
     * @return
     */
    public int minimumLength(String s) {
        char[] sc = s.toCharArray();
        int i = 0, j = sc.length - 1;
        while (i < j) {
            if (sc[i] != sc[j])
                return j - i + 1;
            char c = sc[i];
            while (i <= j && sc[j] == c) {
                j--;
            }
            while (i <= j && sc[i] == c) {
                i++;
            }
        }
        return j - i + 1;
    }

    public static void main(String[] args) {
        MinimumLengthOfStringAfterDeletingSimilarEnds ml = new MinimumLengthOfStringAfterDeletingSimilarEnds();
        System.out.println(ml.minimumLength("ca"));
        System.out.println(ml.minimumLength("cabaabac"));
        System.out.println(ml.minimumLength("aabccabba"));
        System.out.println(ml.minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }
}
