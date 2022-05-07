package leetcode._207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/course-schedule/
 */
public class CourseSchedule {
    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        List<Integer>[] edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }

        // 入度
        int[] inDegrees = new int[numCourses];
        for (int[] preq : prerequisites) {
            edges[preq[1]].add(preq[0]);
            inDegrees[preq[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            Integer u = queue.poll();
            for (Integer v : edges[u]) {
                inDegrees[v]--;
                if (inDegrees[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }

    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        List<Integer>[] edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int[] preq : prerequisites) {
            edges[preq[1]].add(preq[0]);
        }

        // 0: 未访问 1: 访问中 2: 遍历该节点（的所有临近节点）结束
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(edges, visited, i)) {
                return false;
            }
        }
        return true;
    }

    // 本轮搜索中没有环返回 true，有环返回 false
    private boolean dfs(List<Integer>[] edges, int[] visited, int u) {
        if (visited[u] == 1) {
            return false;
        }
        if (visited[u] == 2) {
            return true;
        }
        visited[u] = 1;
        for (int v : edges[u]) {
            if (!dfs(edges, visited, v)) {
                return false;
            }
        }
        visited[u] = 2;
        return true;
    }
}
