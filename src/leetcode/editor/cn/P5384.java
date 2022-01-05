package leetcode.editor.cn;

/**
 * 描述.
 * <p>
 * 创建时间: 2021/8/21 22:33
 *
 * @author KevinHwang
 */
public class P5384 {
    public static void main(String[] args) {
        P5384 solution = new P5384();
        System.out.println(solution.minTimeToType("z"));
        System.out.println(solution.minTimeToType("bza"));
        System.out.println(solution.minTimeToType("zjpc"));
    }

    public int minTimeToType(String word) {
        int n = word.length();
        int pre = 0, ans = n;
        for (int i = 0; i < n; i++) {
            ans += (Math.min((word.charAt(i) - 'a' + 26 - pre) % 26, (pre + 26 - (word.charAt(i) - 'a')) % 26));
            pre = word.charAt(i) - 'a';
        }
        return ans;
    }
}
