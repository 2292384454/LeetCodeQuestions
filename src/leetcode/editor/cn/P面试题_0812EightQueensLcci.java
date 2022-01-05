package leetcode.editor.cn;
//Java：八皇后

import java.util.ArrayList;
import java.util.List;

/**
 * <p>设计一种算法，打印 N 皇后在 N &times; N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的&ldquo;对角线&rdquo;指的是所有的对角线，不只是平分整个棋盘的那两条对角线。</p>
 *
 * <p><strong>注意：</strong>本题相对原题做了扩展</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre><strong> 输入</strong>：4
 * <strong> 输出</strong>：[[&quot;.Q..&quot;,&quot;...Q&quot;,&quot;Q...&quot;,&quot;..Q.&quot;],[&quot;..Q.&quot;,&quot;Q...&quot;,&quot;...Q&quot;,&quot;.Q..&quot;]]
 * <strong> 解释</strong>: 4 皇后问题存在如下两个不同的解法。
 * [
 * &nbsp;[&quot;.Q..&quot;, &nbsp;// 解法 1
 * &nbsp; &quot;...Q&quot;,
 * &nbsp; &quot;Q...&quot;,
 * &nbsp; &quot;..Q.&quot;],
 *
 * &nbsp;[&quot;..Q.&quot;, &nbsp;// 解法 2
 * &nbsp; &quot;Q...&quot;,
 * &nbsp; &quot;...Q&quot;,
 * &nbsp; &quot;.Q..&quot;]
 * ]
 * </pre>
 * <div><div>Related Topics</div><div><li>数组</li><li>回溯</li></div></div><p><div><li>👍 90</li><li>👎 0</li></div>
 */
public class P面试题_0812EightQueensLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0812EightQueensLcci().new Solution();
        // TO TEST
        List<List<String>> ans = solution.solveNQueens(8);
        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> ans;

        public List<List<String>> solveNQueens(int n) {
            ans = new ArrayList<>();
            boolean[] columnState = new boolean[n];
            boolean[] diagonalState1 = new boolean[(n << 1) - 1];
            boolean[] diagonalState2 = new boolean[(n << 1) - 1];
            helper(n, 0, 0, columnState, diagonalState1, diagonalState2, new ArrayList<>());
            return ans;
        }

        /**
         * 逐行尝试放置皇后，进行回溯
         *
         * @param n              总皇后数量
         * @param count          当前已放置的皇后数量
         * @param curRow         当前行
         * @param columnStates   记录每一列是否已经有皇后
         * @param diagonalState1 记录每一对角线（左下至右上）是否有皇后
         * @param diagonalState2 记录每一对角线（左上至右下）是否有皇后
         * @param list           已经放置了皇后的行
         */
        private void helper(int n, int count, int curRow, boolean[] columnStates, boolean[] diagonalState1, boolean[] diagonalState2, List<String> list) {
            if (n == count) {
                ans.add(new ArrayList<>(list));
                return;
            }
            if (curRow == n) {
                return;
            }
            for (int i = 0; i < n; i++) {
                boolean b1 = columnStates[i];
                boolean b2 = diagonalState1[curRow + i];
                boolean b3 = diagonalState2[n - 1 - curRow + i];
                if (!(b1 || b2 || b3)) {
                    // 如果该位置可以放置皇后，就放置之然后回溯
                    // 放置时需要修改标记状态
                    columnStates[i] = true;
                    diagonalState1[curRow + i] = true;
                    diagonalState2[n - 1 - curRow + i] = true;
                    // 创建该行的字符串
                    StringBuilder sb = new StringBuilder();
                    int j = 0;
                    for (; j < n; j++) {
                        if (j == i) {
                            sb.append("Q");
                        } else {
                            sb.append(".");
                        }
                    }
                    // 将字符串添加到列表中
                    list.add(sb.toString());
                    // 进行递归
                    helper(n, count + 1, curRow + 1, columnStates, diagonalState1, diagonalState2, list);
                    // 恢复状态
                    columnStates[i] = false;
                    diagonalState1[curRow + i] = false;
                    diagonalState2[n - 1 - curRow + i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}