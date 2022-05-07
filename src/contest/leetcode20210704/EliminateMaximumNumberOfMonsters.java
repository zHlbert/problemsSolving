package contest.leetcode20210704;

import java.util.*;

/**
 * You are playing a video game where you are defending your city from a group of n monsters. You are given a 0-indexed integer array dist of size n, where dist[i] is the initial distance in meters of the ith monster from the city.
 *
 * The monsters walk toward the city at a constant speed. The speed of each monster is given to you in an integer array speed of size n, where speed[i] is the speed of the ith monster in meters per minute.
 *
 * The monsters start moving at minute 0. You have a weapon that you can choose to use at the start of every minute, including minute 0. You cannot use the weapon in the middle of a minute. The weapon can eliminate any monster that is still alive. You lose when any monster reaches your city. If a monster reaches the city exactly at the start of a minute, it counts as a loss, and the game ends before you can use your weapon in that minute.
 *
 * Return the maximum number of monsters that you can eliminate before you lose, or n if you can eliminate all the monsters before they reach the city.
 */
public class EliminateMaximumNumberOfMonsters {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        Set<Integer> killed = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            int minTIndex = 0;
            double minT = Double.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (killed.contains(j)) {
                    continue;
                }
                if (dist[j] == 0)
                    return i;
                double t = (dist[j] + 0.0) / speed[j];
                if (minT > t) {
                    minT = t;
                    minTIndex = j;
                }
                dist[j] = Math.max(dist[j] - speed[j], 0);
            }
            killed.add(minTIndex);
        }
        return n;
    }

    public int eliminateMaximum1(int[] dist, int[] speed) {
        int len = dist.length;
        List<Double> timeList = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            timeList.add((double) dist[i] / speed[i]);
        }
        timeList.sort(Comparator.comparingDouble(Double::doubleValue));
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (timeList.get(i) > i)
                ans++;
            else
                return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] dist = new int[] {3,2,4};
        int[] speed = new int[] {5,3,2};
        EliminateMaximumNumberOfMonsters e = new EliminateMaximumNumberOfMonsters();
        System.out.println(e.eliminateMaximum1(dist, speed));
    }
}
