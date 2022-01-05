package leetcode.editor.cn;
//Java：从上到下打印二叉树

import java.util.*;

/**
 * <p>从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p>例如:<br>
 * 给定二叉树:&nbsp;<code>[3,9,20,null,null,15,7]</code>,</p>
 *
 * <pre>    3
 * / \
 * 9  20
 * /  \
 * 15   7
 * </pre>
 *
 * <p>返回：</p>
 *
 * <pre>[3,9,20,15,7]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * <li><code>节点总数 &lt;= 1000</code></li>
 * </ol>
 * <div><div>Related Topics</div><div><li>树</li><li>广度优先搜索</li><li>二叉树</li></div></div><p><div><li>👍 106</li><li>👎 0</li></div>
 */
public class P剑指_Offer_32___ICongShangDaoXiaDaYinErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_32___ICongShangDaoXiaDaYinErChaShuLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            List<Integer> ans = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode p = queue.poll();
                ans.add(p.val);
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }
            return Arrays.stream(ans.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}