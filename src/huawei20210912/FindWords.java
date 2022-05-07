package huawei20210912;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindWords {
    static List<List<String>> resultPath = new ArrayList<>();
    static boolean[][] used;
    static String target;
    static int[] dx = new int[] {1, 0, -1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] matrix = new char[n][];
        for (int i = 0; i < n; i++) {
            String currLine = sc.next();
            String[] currChars = currLine.split(",");
            matrix[i] = new char[currChars.length];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = currChars[j].charAt(0);
            }
        }
        used = new boolean[n][matrix[0].length];
        target = sc.next();
        dfs(matrix, 0, 0, 0);
        List<String> resultStrs = new ArrayList<>(resultPath.size());
        for (List<String> strings : resultPath) {
            resultStrs.add(String.join(",", strings));
        }
        System.out.println(String.join(",", resultStrs));
    }

    private static void dfs(char[][] matrix, int x, int y, int index) {
        if (resultPath.size() == target.length()) {
            return;
        }

        if (target.charAt(index) != matrix[y][x]) {
            return;
        }

        List<String> currIndexes = new ArrayList<>();
        currIndexes.add(String.valueOf(y));
        currIndexes.add(String.valueOf(x));
        resultPath.add(currIndexes);

        for (int i = 0; i < 4; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            if (x1 < 0 || x1 >= matrix[0].length || y1 < 0 || y1 >= matrix.length) {
                continue;
            }
            if (used[y1][x1]) {
                continue;
            }
            used[y1][x1] = true;
            dfs(matrix, x1, y1, index + 1);
            used[y1][x1] = false;
        }
    }
}
