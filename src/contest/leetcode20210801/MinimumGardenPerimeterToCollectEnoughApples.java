package contest.leetcode20210801;

/**
 * In a garden represented as an infinite 2D grid, there is an apple tree planted at every integer coordinate. The apple tree planted at an integer coordinate (i, j) has |i| + |j| apples growing on it.
 *
 * You will buy an axis-aligned square plot of land that is centered at (0, 0).
 *
 * Given an integer neededApples, return the minimum perimeter of a plot such that at least neededApples apples are inside or on the perimeter of that plot.
 *
 * The value of |x| is defined as:
 *
 * x if x >= 0
 * -x if x < 0
 */
public class MinimumGardenPerimeterToCollectEnoughApples {
    public long minimumPerimeter(long neededApples) {
        long i0 = 0;
        for (long i = 1; i <= neededApples; i++) {
            long apples = 2 * i * (i + 1) * (2 * i + 1);
            if (apples >= neededApples) {
                i0 = i;
                break;
            }
        }
        return 8 * i0;
    }

    public static void main(String[] args) {
        MinimumGardenPerimeterToCollectEnoughApples m = new MinimumGardenPerimeterToCollectEnoughApples();
        int[] nums = new int[] {1, 13, 30, 60, 61, 167, 168, 169, 1000000000};
        for (int num : nums) {
            System.out.println(num + ": " + m.minimumPerimeter(num));
        }
    }
}
