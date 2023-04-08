package leetcode._2399;

public class CheckDistancesBetweenSameLetters {
    public boolean checkDistances(String s, int[] distance) {
        char[] sc = s.toCharArray();
        int n = sc.length;
        for (int i = 0; i < n; i++) {
            char c = sc[i];
            int idx = c - 'a';
            if (distance[idx] >= 0)  {
                if (distance[idx] + i + 1 < n && sc[distance[idx] + i + 1] == c) {
                    distance[idx] = -1;
                } else return false;
            }
        }
        return true;
    }
}
