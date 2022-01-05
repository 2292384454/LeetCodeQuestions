//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 107 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：从上到下打印二叉树 III
public class P剑指_Offer_32___IIICongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_Offer_32___IIICongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean needReverse = false;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    temp.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                if (needReverse) {
                    Collections.reverse(temp);
                }
                ans.add(temp);
                needReverse = !needReverse;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}