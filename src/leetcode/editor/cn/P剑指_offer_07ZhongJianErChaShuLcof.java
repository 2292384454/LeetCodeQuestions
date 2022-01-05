//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 465 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java：重建二叉树
public class P剑指_offer_07ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指_offer_07ZhongJianErChaShuLcof().new Solution();
        // TO TEST
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        System.out.println(solution.buildTree(preorder, inorder));
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

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = inorder.length;
            HashMap<Integer, Integer> iMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                iMap.put(inorder[i], i);
            }
            return buildTree(preorder, iMap, 0, n - 1, 0, n - 1);
        }

        public TreeNode buildTree(int[] preorder, HashMap<Integer, Integer> iMap, int pL, int pR, int iL, int iR) {
            if (pL > pR || iL > iR) {
                return null;
            }
            // 根节点值
            int rootValue = preorder[pL];
            // 根节点值在中序遍历数组中的位置
            int rootIPos = iMap.get(rootValue);
            // 左右子树大小
            int lTreeSize = rootIPos - iL;
            int rTreeSize = iR - rootIPos;
            TreeNode root = new TreeNode(rootValue);
            root.left = buildTree(preorder, iMap, pL + 1, pL + lTreeSize, iL, rootIPos - 1);
            root.right = buildTree(preorder, iMap, pL + lTreeSize + 1, pL + lTreeSize + rTreeSize, rootIPos + 1, iR);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}