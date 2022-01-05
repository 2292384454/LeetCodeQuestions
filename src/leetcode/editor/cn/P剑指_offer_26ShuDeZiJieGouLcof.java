//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 
// 👍 286 👎 0

package leetcode.editor.cn;

//Java：树的子结构
public class P剑指_offer_26ShuDeZiJieGouLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_26ShuDeZiJieGouLcof().new Solution();
        // TO TEST
        TreeNode A = TreeNode.constructTree(new Integer[]{3, 4, 5, 1, 2});
        TreeNode B = TreeNode.constructTree(new Integer[]{4, 1});
        System.out.println(solution.isSubStructure(A, B));
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
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {
                return false;
            } else {
                return help(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
            }
        }

        /**
         * 找到根节点后，判断B是不是A的子结构并且具有相同的根节点
         */
        public boolean help(TreeNode A, TreeNode B) {
            if (A == null && B == null) {
                // 如果A和B都为null，返回true
                return true;
            } else if (A == null || B == null) {
                // 如果A和B有且只有一个为null，那么B为null返回true，否则返回false
                return B == null;
            } else {
                // 如果A和B都不为null，那么要求 A.val == B.val ，并且对A和B的子节点进行递归判断
                return A.val == B.val && help(A.left, B.left) && help(A.right, B.right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}