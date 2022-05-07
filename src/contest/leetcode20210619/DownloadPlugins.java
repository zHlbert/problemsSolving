package contest.leetcode20210619;

/**
 * 小扣打算给自己的 VS code 安装使用插件，初始状态下带宽每分钟可以完成 1 个插件的下载。假定每分钟选择以下两种策略之一:
 *
 * 使用当前带宽下载插件
 * 将带宽加倍（下载插件数量随之加倍）
 * 请返回小扣完成下载 n 个插件最少需要多少分钟。
 *
 * 注意：实际的下载的插件数量可以超过 n 个
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/Ju9Xwi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DownloadPlugins {
    public int leastMinutes(int n) {
        int speed = 1;
        for (int i = 0; i < 20; i++) {
            if (speed >= n) {
                return i + 1;
            }
            speed = speed << 1;
        }
        return 20;
    }

    public static void main(String[] args) {
        DownloadPlugins d = new DownloadPlugins();
        System.out.println(d.leastMinutes(1));
        System.out.println(d.leastMinutes(2));
        System.out.println(d.leastMinutes(3));
        System.out.println(d.leastMinutes(4));
    }
}
