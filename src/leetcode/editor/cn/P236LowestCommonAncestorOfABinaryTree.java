//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 105] 内。 
// -109 <= Node.val <= 109 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 1109 👎 0

package leetcode.editor.cn;

//Java：二叉树的最近公共祖先
public class P236LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new P236LowestCommonAncestorOfABinaryTree().new Solution();
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
        private TreeNode ans;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            this.dfs(root, p, q);
            return this.ans;
        }

        //后续遍历确定是否p或者q在以root为根的树中
        private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return false;
            }
            boolean lSon = dfs(root.left, p, q);
            boolean rRon = dfs(root.right, p, q);
            //如果p和q分别在root的左右子树 或者 root为p、q之一而另一个在root的子树中
            //总之就是判定root是否是p和q的最近公共祖先
            if ((lSon && rRon) || ((root == p || root == q) && (lSon || rRon))) {
                ans = root;
                return true;
            }
            return (root == p || root == q || lSon || rRon);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
