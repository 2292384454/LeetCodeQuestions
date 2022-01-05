package leetcode.editor.cn;
//Java：二叉树中所有距离为 K 的结点

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>给定一个二叉树（具有根结点&nbsp;<code>root</code>），&nbsp;一个目标结点&nbsp;<code>target</code>&nbsp;，和一个整数值 <code>K</code> 。</p>
 *
 * <p>返回到目标结点 <code>target</code> 距离为 <code>K</code> 的所有结点的值的列表。 答案可以以任何顺序返回。</p>
 *
 * <p>&nbsp;</p>
 *
 * <ol>
 * </ol>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * <strong>输出：</strong>[7,4,1]
 * <strong>解释：</strong>
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 *
 * <img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/06/28/sketch0.png" style="height: 240px; width: 280px;">
 *
 * 注意，输入的 &quot;root&quot; 和 &quot;target&quot; 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * <li>给定的树是非空的。</li>
 * <li>树上的每个结点都具有唯一的值&nbsp;<code>0 &lt;= node.val &lt;= 500</code>&nbsp;。</li>
 * <li>目标结点&nbsp;<code>target</code>&nbsp;是树上的结点。</li>
 * <li><code>0 &lt;= K &lt;= 1000</code>.</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><p><div><li>👍 353</li><li>👎 0</li></div>
 */
public class P863AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P863AllNodesDistanceKInBinaryTree().new Solution();
        // TO TEST
        TreeNode root = TreeNode.constructTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode target = root.left;
        System.out.println(solution.distanceK(root, target, 2));
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
        Map<Integer, TreeNode> parents = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            // 从 root 出发 DFS，记录每个结点的父结点
            findParents(root);
            // 从 target 出发 DFS，寻找所有距离为 k 的结点
            findAns(target, null, k);
            return ans;
        }

        public void findParents(TreeNode node) {
            if (node.left != null) {
                parents.put(node.left.val, node);
                findParents(node.left);
            }
            if (node.right != null) {
                parents.put(node.right.val, node);
                findParents(node.right);
            }
        }

        public void findAns(TreeNode node, TreeNode pre, int k) {
            if (node == null) {
                return;
            }
            if (k == 0) {
                ans.add(node.val);
                return;
            }
            if (node.left != pre) {
                findAns(node.left, node, k - 1);
            }
            if (node.right != pre) {
                findAns(node.right, node, k - 1);
            }
            if (parents.get(node.val) != pre) {
                findAns(parents.get(node.val), node, k - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}