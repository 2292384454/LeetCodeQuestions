package leetcode.editor.cn;

public class P1894FindTheStudentThatWillReplaceTheChalk {
    public static void main(String[] args) {
        Solution solution = new P1894FindTheStudentThatWillReplaceTheChalk().new Solution();
        // TO TEST
        int[] chalk = new int[]{3, 4, 1, 2};
        System.out.println(solution.chalkReplacer(chalk, 25));
    }

    //Java：找到需要补充粉笔的学生编号
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int chalkReplacer(int[] chalk, int k) {
            int n = chalk.length;
            if (n == 1) {
                return 0;
            }
            long[] preSum = new long[n];
            preSum[0] = chalk[0];
            for (int i = 1; i < n; i++) {
                preSum[i] = preSum[i - 1] + chalk[i];
            }
            k %= preSum[n - 1];
            // 找到第一个大于等于 k 的数
            int low = 0, high = n - 1, mid;
            while (low <= high) {
                mid = (low + high) >> 1;
                if (preSum[mid] == k) {
                    return (mid + 1) % n;
                } else if (preSum[mid] < k) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}