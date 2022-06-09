package leetcode._461;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor > 0) {
            distance += xor & 1;
            xor = xor >> 1;
        }
        return distance;
    }

    public int hammingDistanceBrian(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor > 0) {
            // 每次去掉xor中最右侧的0
            xor &= xor - 1;
            distance++;
        }
        return distance;
    }

    public static void main(String[] args) {
        HammingDistance hd = new HammingDistance();
        System.out.println(hd.hammingDistance(3,1));
    }
}
