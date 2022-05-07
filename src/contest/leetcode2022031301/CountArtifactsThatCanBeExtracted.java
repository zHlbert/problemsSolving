package contest.leetcode2022031301;

/**
 * There is an n x n 0-indexed grid with some artifacts buried in it. You are given the integer n and a 0-indexed 2D integer array artifacts describing the positions of the rectangular artifacts where artifacts[i] = [r1i, c1i, r2i, c2i] denotes that the ith artifact is buried in the subgrid where:
 *
 * (r1i, c1i) is the coordinate of the top-left cell of the ith artifact and
 * (r2i, c2i) is the coordinate of the bottom-right cell of the ith artifact.
 * You will excavate some cells of the grid and remove all the mud from them. If the cell has a part of an artifact buried underneath, it will be uncovered. If all the parts of an artifact are uncovered, you can extract it.
 *
 * Given a 0-indexed 2D integer array dig where dig[i] = [ri, ci] indicates that you will excavate the cell (ri, ci), return the number of artifacts that you can extract.
 *
 * The test cases are generated such that:
 *
 * No two artifacts overlap.
 * Each artifact only covers at most 4 cells.
 * The entries of dig are unique.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-artifacts-that-can-be-extracted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountArtifactsThatCanBeExtracted {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[] isDig = new boolean[n * n];
        for (int[] d : dig) {
            isDig[d[0] * n + d[1]] = true;
        }
        int ans = 0;
        for (int[] artifact : artifacts) {
            boolean canBeExtracted = true;
            for (int i = artifact[0]; i <= artifact[2] && canBeExtracted; i++) {
                for (int j = artifact[1]; j <= artifact[3] && canBeExtracted; j++) {
                    canBeExtracted = isDig[i * n + j];
                }
            }
            if (canBeExtracted) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountArtifactsThatCanBeExtracted c = new CountArtifactsThatCanBeExtracted();
        int n = 2;
        int[][] artifacts = new int[][] {{0,0,0,0},{0,1,1,1}};
        int[][] dig = new int[][] {{0,0},{0,1},{1,1}};
        System.out.println(c.digArtifacts(n, artifacts, dig));
    }
}
