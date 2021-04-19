//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。 
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2h 个节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 104] 
// 0 <= Node.val <= 5 * 104 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
// Related Topics 树 二分查找 
// 👍 468 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//Java：完全二叉树的节点个数
public class P222CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new P222CountCompleteTreeNodes().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(1);
        System.out.println(solution.countNodes(root));
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

        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            TreeNode p = root;
            //计算二叉树深度
            int totalDepth = 0;
            while (p != null) {
                totalDepth++;
                p = p.left;
            }
            //该二叉树最少可能的节点数 和 最多可能的节点数
            int low = 1 << (totalDepth - 1), high = (1 << totalDepth) - 1, mid = 0;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (exists(root, totalDepth, mid))
                    low = mid + 1;
                else high = mid - 1;
            }
            return low - 1;
        }

        /**
         * @param root  树
         * @param level 要找的节点的层数
         * @param num   节点编号
         * @return 对于以root为根节点的完全二叉树中，按照从1到n的层序遍历顺序进行编号。返回编号为num的节点是否存在
         */
        public boolean exists(TreeNode root, int level, int num) {
            int bits = 1 << (level - 2);
            TreeNode node = root;
            while (node != null && bits > 0) {
                node = ((bits & num) == 0) ? node.left : node.right;
                bits >>= 1;
            }
            return node != null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
