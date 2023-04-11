package leetcode._1041;

public class RobotBoundedInCircle {
    static final int[][] d = new int[][] {{0,1},{-1,0},{0,-1},{1,0}};

    /**
     * 每次指令结束的最终位置不变或 方向改变 则有环
     * @param instructions
     * @return
     */
    public boolean isRobotBounded(String instructions) {
        char[] sc = instructions.toCharArray();
        int[] loc = new int[2];
        int di = 0;
        for (char c : sc) {
            if (c == 'G') {
                loc[0] += d[di][0];
                loc[1] += d[di][1];
            }
            else if (c == 'L') di = (di + 3) % 4;
            else di = (di + 1) % 4;
        }
        return loc[0] == 0 && loc[1] == 0 || di != 0;
    }

    public static void main(String[] args) {
        RobotBoundedInCircle rb = new RobotBoundedInCircle();
        System.out.println(rb.isRobotBounded("GGLLGG"));
        System.out.println(rb.isRobotBounded("GG"));
        System.out.println(rb.isRobotBounded("GL"));
    }
}
