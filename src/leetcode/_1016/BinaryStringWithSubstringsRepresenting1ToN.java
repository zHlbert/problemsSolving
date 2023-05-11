package leetcode._1016;

public class BinaryStringWithSubstringsRepresenting1ToN {
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if (!s.contains(Integer.toBinaryString(i))) return false;
        }
        return true;
    }

    // TODO: 2023/5/11 双指针
}
