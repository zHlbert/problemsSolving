package leetcode._874;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WalkingRobotSimulation {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, Set<Integer>> x2y = new HashMap<>();
        Map<Integer, Set<Integer>> y2x = new HashMap<>();

        for (int[] ob : obstacles) {
            if (!x2y.containsKey(ob[0])) {
                x2y.put(ob[0], new HashSet<>());
            }
            if (!y2x.containsKey(ob[1])) {
                y2x.put(ob[1], new HashSet<>());
            }
            x2y.get(ob[0]).add(ob[1]);
            y2x.get(ob[1]).add(ob[0]);
        }

        int di = 0;
        int x = 0, y = 0;
        int res = 0;
        for (int cm : commands) {
//            System.out.println(cm);
            if (cm == -1) {
                di = (di + 1) % 4;
            } else if (cm == -2) {
                di = (di + 3) % 4;
            } else {
                int nx = x + cm * dx[di];
                int ny = y + cm * dy[di];
                if (dx[di] == 0) {
                    if (!x2y.containsKey(x)) {
                        y = ny;
                    } else {
                        Set<Integer> ys = x2y.get(x);
                        for (int i = 0, j = 0; i <= cm; i++, j += dy[di]) {
                            if (ys.contains(y + j)) {
                                break;
                            }
                            ny = y + j;
                        }
                        y = ny;
                    }
                } else {
                    if (!y2x.containsKey(y)) {
                        x = nx;
                    } else {
                        Set<Integer> xs = y2x.get(y);
                        for (int i = 0, j = 0; i <= cm; i++, j += dx[di]) {
                            if (xs.contains(x + j)) {
                                break;
                            }
                            nx = x + j;
                        }
                        x = nx;
                    }
                }
                res = Math.max(res, x * x + y * y);
            }
        }
        return res;
    }

    public int robotSim1(int[] commands, int[][] obstacles) {
        Set<Long> xySet = new HashSet<>();
        for (int[] ob : obstacles) {
            xySet.add(((long) ob[0] << 16) + ob[1]);
        }
        int x = 0, y = 0;
        int di = 0;
        int res = 0;
        for (int cm : commands) {
            if (cm == -1) {
                di = (di + 1) % 4;
            } else if (cm == -2) {
                di = (di + 3) % 4;
            } else {
                for (int i = 0; i < cm; i++) {
                    long xy = ((long) (x + dx[di]) << 16) + (y + dy[di]);
                    if (xySet.contains(xy)) {
                        break;
                    }
                    x = x + dx[di];
                    y = y + dy[di];
                    res = Math.max(res, x * x + y * y);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        WalkingRobotSimulation wr = new WalkingRobotSimulation();
        int[] commands = {-2,8,3,7,-1};
        int[][] obstacles = {{-4,-1},{1,-1},{1,4},{5,0},{4,5},{-2,-1},{2,-5},{5,1},{-3,-1},{5,-3}};
        System.out.println(wr.robotSim1(commands, obstacles));
    }
}
