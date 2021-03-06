package contest.leetcode20220417;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a 2D integer array grid of size m x n, where each cell contains a positive integer.
 *
 * A cornered path is defined as a set of adjacent cells with at most one turn. More specifically, the path should exclusively move either horizontally or vertically up to the turn (if there is one), without returning to a previously visited cell. After the turn, the path will then move exclusively in the alternate direction: move vertically if it moved horizontally, and vice versa, also without returning to a previously visited cell.
 *
 * The product of a path is defined as the product of all the values in the path.
 *
 * Return the maximum number of trailing zeros in the product of a cornered path found in grid.
 *
 * Note:
 *
 * Horizontal movement means moving in either the left or right direction.
 * Vertical movement means moving in either the up or down direction.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-trailing-zeros-in-a-cornered-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumTrailingZerosInACorneredPath {
    Map<Integer, Integer> divFBy2 = new HashMap<>();
    Map<Integer, Integer> divFBy5 = new HashMap<>();

    public int maxTrailingZeros(int[][] grid) {
        int maxZeros = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (divFBy2(grid[i][j]) == 0 && divFBy5(grid[i][j]) == 0) {
                    continue;
                }
                int maxZerosIJ = 0;
                int countFor2 = 0;
                int countFor5 = 0;
                for (int k = 0; k < grid[i].length - j; k++) {
                    countFor2 += divFBy2(grid[i][j + k]);
                    countFor5 += divFBy5(grid[i][j + k]);
                    int countFor2TmpR = 0;
                    int countFor5TmpR = 0;
                    int countFor2TmpL = 0;
                    int countFor5TmpL = 0;
                    for (int l = i - 1; l >= 0; l--) {
                        countFor2TmpR += divFBy2(grid[l][j + k]);
                        countFor5TmpR += divFBy5(grid[l][j + k]);
                        countFor2TmpL += divFBy2(grid[l][j]);
                        countFor5TmpL += divFBy5(grid[l][j]);
                    }
                    maxZerosIJ = Math.max(maxZerosIJ, Math.min(countFor2 + countFor2TmpR, countFor5 + countFor5TmpR));
                    maxZerosIJ = Math.max(maxZerosIJ, Math.min(countFor2 + countFor2TmpL, countFor5 + countFor5TmpL));
                    countFor2TmpR = 0;
                    countFor5TmpR = 0;
                    countFor2TmpL = 0;
                    countFor5TmpL = 0;
                    for (int l = i + 1; l < grid.length; l++) {
                        countFor2TmpR += divFBy2(grid[l][j + k]);
                        countFor5TmpR += divFBy5(grid[l][j + k]);
                        countFor2TmpL += divFBy2(grid[l][j]);
                        countFor5TmpL += divFBy5(grid[l][j]);
                    }
                    maxZerosIJ = Math.max(maxZerosIJ, Math.min(countFor2 + countFor2TmpR, countFor5 + countFor5TmpR));
                    maxZerosIJ = Math.max(maxZerosIJ, Math.min(countFor2 + countFor2TmpL, countFor5 + countFor5TmpL));
                }
                maxZeros = Math.max(maxZeros, maxZerosIJ);
            }
        }
        return maxZeros;
    }

    private int divFBy5(int num) {
        if (divFBy5.containsKey(num)) {
            return divFBy5.get(num);
        }
        int divisorNum5 = divisorNum(num, 5);
        divFBy5.put(num, divisorNum5);
        return divisorNum5;
    }

    private int divFBy2(int num) {
        if (divFBy2.containsKey(num)) {
            return divFBy2.get(num);
        }
        int divisorNum2 = divisorNum(num, 2);
        divFBy2.put(num, divisorNum2);
        return divisorNum2;
    }

    public int divisorNum(int num, int d) {
        int divNum = 0;
        while (num % d == 0) {
            divNum++;
            num = num / d;
        }
        return divNum;
    }

    public int maxTrailingZerosSimple(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // r[i][j] 表示grid[i][j]左边的 2/5 因子总个数（不含自身）
        // c[i][j] 表示grid[i][j]上边的 2/5 因子总个数（不含自身）
        int[][] r2 = new int[m + 1][n + 1], r5 = new int[m + 1][n + 1], c2 = new int[m + 1][n + 1], c5 = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int currNum = grid[i - 1][j - 1];
                int num2 = divFBy2(currNum);
                int num5 = divFBy5(currNum);
                r2[i][j] = r2[i][j - 1] + num2;
                r5[i][j] = r5[i][j - 1] + num5;
                c2[i][j] = c2[i - 1][j] + num2;
                c5[i][j] = c5[i - 1][j] + num5;
            }
        }

        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 左 -> 右 -> 上
                int rightUp = Math.min(r2[i][j] + c2[i - 1][j], r5[i][j] + c5[i - 1][j]);
                res = Math.max(res, rightUp);

                // 左 -> 右 -> 下
                int rightDown = Math.min(r2[i][j] + c2[m][j] - c2[i][j], r5[i][j] + c5[m][j] - c5[i][j]);
                res = Math.max(res, rightDown);

                // 右 -> 左 -> 上
                int leftUp = Math.min(r2[i][n] - r2[i][j] + c2[i][j], r5[i][n] - r5[i][j] + c5[i][j]);
                res = Math.max(res, leftUp);

                // 右 -> 左 -> 下
                int leftDown = Math.min(r2[i][n] - r2[i][j - 1] + c2[m][j] - c2[i][j], r5[i][n] - r5[i][j - 1] + c5[m][j] - c5[i][j]);
                res = Math.max(res, leftDown);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumTrailingZerosInACorneredPath m = new MaximumTrailingZerosInACorneredPath();
//        int[][] grid = new int[][] {{4,3,2},{7,6,1},{8,8,8}};
//        int[][] grid = new int[][] {{23,17,15,3,20},{8,1,20,27,11},{9,4,6,2,21},{40,9,1,10,6},{22,7,4,5,3}};
        int[][] grid = new int[][] {{899,727,165,249,531,300,542,890},{981,587,565,943,875,498,582,672},{106,902,524,725,699,778,365,220}};
//        int[][] grid = new int[][] {{1,5,2,4,25}};
//        int[][] grid = new int[][] {{10},{6},{15}};
//        int[][] grid = new int[][] {{824,709,193,413,701,836,727},{135,844,599,211,140,933,205},{329,68,285,282,301,387,231},{293,210,478,352,946,902,137},{806,900,290,636,589,522,611},{450,568,990,592,992,128,92},{780,653,795,457,980,942,927},{849,901,604,906,912,866,688}};
//        int[][] grid = new int[][] {{82,943,432,304,83,185,822,504,980,284,95,632,613,708,164,87,229,493,551,16,42,339,555,218,43,417,866,366,616,745,979,105,876,845,427,767,581,852,818,849,420,582,322,903,868},{873,948,503,224,885,348,50,308,771,512,215,177,288,278,605,793,552,524,934,601,113,895,467,165,967,41,998,405,35,46,402,842,396,410,894,938,466,758,505,407,361,995,908,268,795},{971,872,357,667,427,890,114,191,46,689,126,583,592,63,239,968,393,996,86,963,547,435,797,486,102,855,340,786,434,642,607,699,848,940,998,432,194,412,925,999,560,929,163,703,739},{557,637,20,770,565,982,829,869,176,963,176,186,181,11,944,421,671,455,890,157,412,329,339,808,515,686,687,974,595,302,38,843,54,693,815,630,982,318,761,922,924,190,640,786,762},{317,913,771,48,343,949,707,240,609,171,766,113,121,403,795,574,987,975,729,660,999,621,644,676,108,238,589,912,591,450,424,651,962,958,858,235,892,882,603,702,63,150,174,687,802},{146,740,434,452,709,332,121,533,728,929,922,145,496,589,652,804,599,914,821,356,644,70,108,900,577,691,426,249,934,260,246,579,127,997,850,702,124,940,614,560,636,688,253,899,555},{370,757,104,398,658,55,864,689,637,264,738,9,790,716,264,297,540,134,701,387,666,537,199,346,647,673,482,81,289,500,851,551,911,298,872,659,822,656,261,959,738,896,473,94,315},{212,930,130,545,415,253,900,795,422,505,121,401,99,611,301,998,557,161,630,348,167,731,671,933,576,114,921,590,90,180,212,762,462,471,772,490,259,88,727,348,766,230,957,634,401},{302,162,310,303,493,808,706,784,795,926,858,641,364,437,789,782,919,449,739,556,985,93,214,101,222,439,955,654,68,761,547,998,163,968,235,581,571,412,902,482,974,771,660,604,607},{421,939,676,845,187,507,916,650,347,996,324,327,395,797,108,237,159,896,698,74,247,855,476,461,115,456,223,537,603,64,682,804,542,778,199,541,554,296,617,920,681,885,322,64,179},{664,931,783,137,699,703,382,111,123,776,152,255,653,727,116,490,901,872,378,704,758,560,832,201,530,392,704,662,162,374,959,744,147,388,936,476,999,636,759,617,495,853,363,445,858},{8,289,629,438,904,890,237,497,508,42,800,690,320,22,735,128,319,86,530,127,355,815,661,71,284,675,955,107,876,451,309,186,715,375,629,131,191,120,352,130,498,964,851,565,205},{908,171,694,319,442,960,414,969,751,38,890,291,78,163,932,989,640,56,513,997,596,471,575,230,812,613,505,14,726,932,278,921,388,929,908,994,58,660,432,807,906,752,514,592,827},{239,905,520,199,10,700,917,816,395,846,971,384,511,779,816,301,208,918,57,359,964,616,482,943,718,498,540,739,794,587,952,706,846,357,411,802,652,676,741,287,566,203,465,703,864},{937,605,223,552,854,146,215,83,29,613,859,898,544,703,92,573,190,854,225,349,527,814,37,127,271,449,605,582,297,376,661,425,321,172,217,75,381,872,750,739,70,21,308,420,878},{718,876,802,664,758,105,625,262,27,584,475,97,755,68,963,404,836,682,34,249,814,924,352,378,508,296,511,168,840,282,126,96,73,694,285,142,80,600,919,933,143,9,682,689,286},{570,999,737,952,451,1,488,705,763,441,308,463,205,418,372,232,392,597,906,306,507,889,263,25,128,689,974,803,386,308,893,804,815,450,994,560,704,613,516,384,984,24,977,122,870},{326,321,14,280,48,424,622,229,619,560,795,684,150,26,830,389,812,617,949,106,117,500,936,145,649,820,878,302,610,386,626,81,705,860,858,156,177,987,4,19,554,545,742,112,17},{367,134,109,416,831,484,42,753,950,231,265,847,111,444,731,564,175,408,117,796,825,871,833,71,513,323,861,349,944,441,520,980,765,265,462,758,403,190,929,809,457,512,293,140,805},{226,155,410,950,460,737,925,550,736,262,681,321,231,639,341,542,851,820,255,961,671,252,891,400,496,944,435,44,505,595,474,294,352,6,983,919,780,946,247,220,993,918,536,16,35},{781,962,348,477,83,256,44,798,726,859,46,66,102,5,283,954,376,473,667,479,417,424,555,247,144,618,489,970,539,491,451,952,962,317,922,701,136,598,138,445,608,422,901,476,5},{654,939,684,322,365,819,143,966,60,288,97,954,179,493,619,582,141,177,690,153,775,650,298,969,778,444,51,271,640,39,602,981,118,305,166,260,271,428,641,991,747,959,187,698,269},{580,185,4,344,890,570,882,41,902,193,654,888,455,807,726,356,232,225,466,361,587,520,52,832,23,516,504,919,353,872,726,855,182,824,755,485,67,8,888,524,905,407,90,32,876},{326,16,733,845,157,362,330,609,951,312,998,983,26,416,414,830,569,804,938,16,234,829,407,746,906,665,996,108,488,538,816,205,955,948,848,891,661,273,837,951,632,659,567,195,119},{509,866,489,162,540,764,852,557,365,537,815,119,595,233,179,540,991,840,325,259,332,56,807,150,623,492,170,299,35,814,58,671,350,539,587,383,514,366,74,882,715,705,294,543,743},{238,724,584,458,835,256,225,877,450,257,764,309,48,505,146,283,126,869,33,561,382,80,578,639,126,770,859,968,954,796,253,668,145,300,479,260,611,987,69,430,761,501,567,908,946},{137,577,29,358,653,661,402,404,934,352,648,733,341,64,145,411,729,550,513,676,819,787,38,452,199,947,398,797,192,390,340,468,701,654,775,122,825,88,246,80,756,751,485,644,196},{672,147,16,171,341,884,625,11,128,987,272,801,157,645,246,303,973,786,713,948,499,806,86,783,543,993,461,67,641,636,343,586,218,503,337,903,959,206,376,137,911,92,248,717,727},{491,947,4,534,661,144,662,541,864,625,678,926,674,71,286,812,126,572,317,604,603,869,739,617,836,547,116,769,577,468,826,396,627,122,399,58,636,684,954,410,445,272,346,735,50},{117,555,253,843,30,705,114,653,64,258,696,437,997,61,574,33,752,676,363,91,41,729,339,621,32,488,244,749,348,491,723,660,813,904,826,177,996,871,623,283,572,724,806,123,347},{702,432,71,31,589,252,352,659,656,648,713,772,466,340,899,77,307,19,310,895,706,367,253,149,714,684,671,708,603,174,478,214,567,227,12,535,662,769,619,477,462,658,386,937,432},{874,161,428,220,126,47,652,816,391,321,91,610,236,42,988,50,884,927,886,576,163,902,590,284,699,758,767,255,432,858,174,367,912,102,674,734,867,455,691,675,840,540,864,127,531},{274,819,730,183,678,608,336,347,779,575,349,865,819,204,255,116,554,665,769,208,159,192,74,81,509,35,377,219,463,844,241,61,598,746,585,286,381,375,886,621,328,302,291,430,159},{181,255,665,85,330,439,302,526,157,590,223,150,131,586,647,546,765,274,958,603,948,751,259,657,351,872,338,832,55,450,550,184,605,617,886,770,39,548,469,1,636,387,654,736,847},{488,505,407,936,549,712,216,823,357,916,346,734,290,430,970,933,797,83,753,687,551,91,545,858,655,735,87,618,769,121,627,729,505,745,586,603,840,738,705,697,257,293,533,294,207},{777,270,579,743,203,553,702,913,998,453,20,737,260,68,622,708,682,216,393,952,927,87,424,777,982,244,269,955,321,874,781,706,746,165,816,155,143,32,201,123,270,763,686,73,54},{605,248,596,92,485,126,753,124,345,465,312,801,218,952,635,887,425,60,670,831,720,822,854,543,682,977,938,237,532,824,388,188,624,891,127,233,927,147,688,580,163,579,309,747,163},{592,251,448,883,137,677,43,529,610,355,313,704,943,622,245,86,719,309,352,518,50,519,789,148,247,36,189,11,468,552,672,580,851,858,544,368,368,943,174,597,611,468,732,358,260},{340,858,706,128,162,242,791,943,324,547,252,683,342,298,482,724,992,712,381,147,503,685,914,270,541,914,466,808,971,344,647,180,318,505,972,472,191,195,337,281,245,540,871,42,400},{602,772,550,646,363,911,807,264,516,47,955,563,438,974,616,840,755,574,496,467,492,472,942,334,506,315,234,832,695,266,348,210,692,231,533,182,292,790,357,87,486,978,348,448,529},{186,45,947,368,995,829,469,457,148,419,87,695,928,527,913,323,552,481,717,933,911,834,460,926,843,77,520,703,791,724,684,638,636,639,53,973,295,171,675,406,497,244,413,545,698}};
        System.out.println(m.maxTrailingZerosSimple(grid));
//        System.out.println(m.divFBy5(15));
    }
}
