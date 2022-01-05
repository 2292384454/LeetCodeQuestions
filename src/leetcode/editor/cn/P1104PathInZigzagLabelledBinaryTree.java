package leetcode.editor.cn;
//Java：二叉树寻路

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 <strong>逐行</strong> 依次按&nbsp;&ldquo;之&rdquo; 字形进行标记。</p>
 *
 * <p>如下图所示，在奇数行（即，第一行、第三行、第五行&hellip;&hellip;）中，按从左到右的顺序进行标记；</p>
 *
 * <p>而偶数行（即，第二行、第四行、第六行&hellip;&hellip;）中，按从右到左的顺序进行标记。</p>
 *
 * <p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/06/28/tree.png" style="height: 138px; width: 300px;"></p>
 *
 * <p>给你树上某一个节点的标号 <code>label</code>，请你返回从根节点到该标号为 <code>label</code> 节点的路径，该路径是由途经的节点标号所组成的。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>label = 14
 * <strong>输出：</strong>[1,3,4,14]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>label = 26
 * <strong>输出：</strong>[1,2,6,10,26]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= label &lt;= 10^6</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>数学</li><li>二叉树</li></div></div><p><div><li>👍 114</li><li>👎 0</li></div>
 */
public class P1104PathInZigzagLabelledBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P1104PathInZigzagLabelledBinaryTree().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            // level 表示 label 所在层数
            int level = (int) (Math.log(label) / Math.log(2)) + 1;
            List<Integer> ans = new ArrayList<>(level);
            // 对于第 k 层的节点 i ，它的父节点是：3*2 ^ (k - 2) - 1 - ⌊i / 2⌋，其中⌊x⌋表示 x 的向下取整
            for (int k = level, i = label; k >= 1; k--) {
                ans.add(i);
                i = 3 * (1 << (k - 2)) - 1 - (i >> 1);
            }
            Collections.reverse(ans);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}