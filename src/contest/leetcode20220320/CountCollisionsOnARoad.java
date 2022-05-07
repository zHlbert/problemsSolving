package contest.leetcode20220320;

public class CountCollisionsOnARoad {
    public int countCollisions(String directions) {
        char[] chars = directions.toCharArray();
        int collisions = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == 'R' && chars[i] != 'R') {
                if (chars[i] == 'S') {
                    collisions++;
                } else if (chars[i] == 'L') {
                    collisions += 2;
                    chars[i] = 'S';
                }
                chars[i - 1] = 'S';
                for (int j = i - 2; j >= 0; j--) {
                    if (chars[j] == 'L' || chars[j] == 'S') {
                        break;
                    }
                    chars[j] = 'S';
                    collisions++;
                }
            } else if (chars[i - 1] == 'S' && chars[i] == 'L') {
                collisions++;
                chars[i] = 'S';
            }
        }

        return collisions;
    }

    public static void main(String[] args) {
        CountCollisionsOnARoad c = new CountCollisionsOnARoad();
        String directions = "SSRSSRLL" +
                "RSLLRSRS" +
                "SRLRRRRL" +
                "LRRLSSRR";
        System.out.println(directions.length());
        System.out.println(c.countCollisions(directions));
    }
}
