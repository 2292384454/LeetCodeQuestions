//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 836 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：不同的二叉搜索树 II
public class P95UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new P95UniqueBinarySearchTreesIi().new Solution();
        // TO TEST
        solution.generateTrees(4);
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
        public List<TreeNode> generateTrees(int n) {
            return help(1, n);
        }

        public List<TreeNode> help(int left, int right) {
            List<TreeNode> ans = new ArrayList<>();
            if (left > right) {
                ans.add(null);
            }
            for (int i = left; i <= right; i++) {
                TreeNode root = new TreeNode(i);
                List<TreeNode> leftNodes = help(left, i - 1);
                List<TreeNode> rightNodes = help(i + 1, right);
                for (TreeNode leftNode : leftNodes) {
                    root.left = leftNode;
                    for (TreeNode rightNode : rightNodes) {
                        root.right = rightNode;
                        ans.add(root);
                        root = new TreeNode(root.val);//避免修改上一个root
                        root.left = leftNode;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
