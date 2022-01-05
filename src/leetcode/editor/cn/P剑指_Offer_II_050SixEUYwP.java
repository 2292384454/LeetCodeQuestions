package leetcode.editor.cn;
//Java：向下的路径节点之和

import java.util.HashMap;

/**
 * <p>给定一个二叉树的根节点 <code>root</code>&nbsp;，和一个整数 <code>targetSum</code> ，求该二叉树里节点值之和等于 <code>targetSum</code> 的 <strong>路径</strong> 的数目。</p>
 *
 * <p><strong>路径</strong> 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><img src="https://assets.leetcode.com/uploads/2021/04/09/pathsum3-1-tree.jpg" style="width: 452px; " /></p>
 *
 * <pre>
 * <strong>输入：</strong>root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * <strong>输出：</strong>3
 * <strong>解释：</strong>和等于 8 的路径有 3 条，如图所示。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * <strong>输出：</strong>3
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li>二叉树的节点个数的范围是 <code>[0,1000]</code></li>
 * <li><meta charset="UTF-8" /><code>-10<sup><span style="font-size: 9.449999809265137px;">9</span></sup>&nbsp;&lt;= Node.val &lt;= 10<sup><span style="font-size: 9.449999809265137px;">9</span></sup></code>&nbsp;</li>
 * <li><code>-1000&nbsp;&lt;= targetSum&nbsp;&lt;= 1000</code>&nbsp;</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 437&nbsp;题相同：<a href="https://leetcode-cn.com/problems/path-sum-iii/">https://leetcode-cn.com/problems/path-sum-iii/</a></p>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_050SixEUYwP {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_II_050SixEUYwP().new Solution();
        // TO TEST
        TreeNode root = TreeNode.constructTree(new Integer[]{1, null, 2, null, 3, null, 4, null, 5});
        System.out.println(solution.pathSum(root, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        HashMap<Integer, Integer> map = new HashMap<>();

        public int pathSum(TreeNode root, int targetSum) {
            map.put(0, 1);
            return dfs(root, targetSum, 0);
        }

        public int dfs(TreeNode root, int targetSum, int sum) {
            if (root == null) return 0;
            int res = 0;
            sum += root.val;
            res += map.getOrDefault(sum - targetSum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            res += dfs(root.left, targetSum, sum);
            res += dfs(root.right, targetSum, sum);
            map.put(sum, map.get(sum) - 1);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}