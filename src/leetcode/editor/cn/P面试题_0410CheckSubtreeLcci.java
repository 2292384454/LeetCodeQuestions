package leetcode.editor.cn;
//Java：检查子树

/**
 * <p>检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。</p>
 *
 * <p>如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。</p>
 *
 * <p><strong>注意：</strong>此题相对书上原题略有改动。</p>
 *
 * <p><strong>示例1:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：t1 = [1, 2, 3], t2 = [2]
 * <strong> 输出</strong>：true
 * </pre>
 *
 * <p><strong>示例2:</strong></p>
 *
 * <pre>
 * <strong> 输入</strong>：t1 = [1, null, 2, 4], t2 = [3, 2]
 * <strong> 输出</strong>：false
 * </pre>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * <li>树的节点数目范围为[0, 20000]。</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li><li>字符串匹配</li><li>哈希函数</li></div></div><p><div><li>👍 39</li><li>👎 0</li></div>
 */
public class P面试题_0410CheckSubtreeLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0410CheckSubtreeLcci().new Solution();
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
        public boolean checkSubTree(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                // t1 与 t2 都为 null ，返回 true
                return true;
            } else if (t1 == null || t2 == null) {
                // t1 与 t2 一个为 null ，另一个不为 null ，返回 false
                return false;
            } else if (t1.val == t2.val) {
                // t1 与 t2 都不为 null ，并且 val 相等，继续往下判断
                return checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
            } else {
                // t1 与 t2 都不为 null ，并且 val 不相等，继续往下判断
                return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}