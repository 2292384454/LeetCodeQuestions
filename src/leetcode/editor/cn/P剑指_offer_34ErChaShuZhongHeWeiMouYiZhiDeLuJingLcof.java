//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 target = 22， 
//
// 
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 187 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树中和为某一值的路径
public class P剑指_offer_34ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_34ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
        // TO TEST
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
        List<List<Integer>> ans = new ArrayList<>();


        public List<List<Integer>> pathSum(TreeNode root, int target) {
            helper(root, target, new ArrayList<>());
            return ans;
        }

        /**
         * 回溯法
         */
        private void helper(TreeNode root, int target, List<Integer> list) {
            List<Integer> copy = new ArrayList<>(list);
            if (root != null) {
                copy.add(root.val);
                if (target == root.val && root.left == null && root.right == null) {
                    ans.add(copy);
                    return;
                }
                helper(root.left, target - root.val, copy);
                helper(root.right, target - root.val, copy);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}