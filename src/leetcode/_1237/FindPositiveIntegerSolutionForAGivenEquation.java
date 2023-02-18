package leetcode._1237;

import java.util.ArrayList;
import java.util.List;

public class FindPositiveIntegerSolutionForAGivenEquation {
    /**
     * 双指针
     * @param customfunction
     * @param z
     * @return
     */
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int x = 1, y = 1000; x <= 1000; x++) {
            while (y > 0 && customfunction.f(x, y) > z) {
                y--;
            }
            if (y == 0) break;
            if (customfunction.f(x, y) == z) {
                List<Integer> solution = new ArrayList<>();
                solution.add(x);
                solution.add(y);
                res.add(solution);
            }
        }
        return res;
    }

    // TODO: 2023/2/18 二分
}


// This is the custom function interface.
// You should not implement it, or speculate about its implementation
class CustomFunction {
      // Returns f(x, y) for any given positive integers x and y.
              // Note that f(x, y) is increasing with respect to both x and y.
              // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)

    public int f(int x, int y) {
        return 0;
    }
}
