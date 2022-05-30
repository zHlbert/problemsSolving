package leetcode._210;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/course-schedule-ii/
 */
public class CourseScheduleII {
    // 拓扑排序
    public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
        List<Integer>[] edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }

        // 入度
        int[] inDegrees = new int[numCourses];
        for (int[] preq : prerequisites) {
            inDegrees[preq[0]]++;
            edges[preq[1]].add(preq[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        int[] ans = new int[numCourses];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            ans[visited] = u;
            visited++;
            for (int v : edges[u]) {
                inDegrees[v]--;
                if (inDegrees[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses ? ans : new int[0];
    }

    int index;
    int[] ans;

    public int[] findOrderDFS(int numCourses, int[][] prerequisites) {
        List<Integer>[] edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int[] preq : prerequisites) {
            edges[preq[1]].add(preq[0]);
        }
        int[] visited = new int[numCourses];
        index = numCourses - 1;
        ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(edges, visited, i)) {
                return new int[0];
            }
        }
        return ans;
    }

    private boolean dfs(List<Integer>[] edges, int[] visited, int u) {
        if (visited[u] == 1) {
            return false;
        }
        if (visited[u] == 2) {
            return true;
        }
        visited[u] = 1;
        for (Integer v : edges[u]) {
            if (!dfs(edges, visited, v)) {
                return false;
            }
        }

        visited[u] = 2;
        ans[index--] = u;
        return true;
    }

    public static void main(String[] args) {
        CourseScheduleII cs2 = new CourseScheduleII();
        int numCourses = 4;
//        int[][] prerequisites = new int[][] {{0,1},{1,0}};
        int[][] prerequisites = new int[][] {{1,0},{2,0},{3,1},{3,2}};
        ArrayUtils.printArray(cs2.findOrderDFS(numCourses, prerequisites));
    }
}
