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
            int len = inorder.length;
            if (len == 0) return null;
            //记录中序遍历数组中每个数字出现的位置，后面就不再用inorder了而是用这个
            HashMap<Integer, Integer> posInInorder = new HashMap<>();
            for (int i = 0; i < len; i++) {
                posInInorder.put(inorder[i], i);
            }
            return buildTree(preorder, posInInorder, 0, len, 0, len);
        }

        /**
         * 根据先序遍历数组和中序遍历的元素-位置对应关系创建二叉树
         * @param preorder 先序遍历数组
         * @param posInInorder 中序遍历的元素-位置对应关系
         * @param preL 先序遍历数组的左边界（包含）
         * @param preR 先序遍历数组的右边界（不包含）
         * @param inL 中序遍历数组的左边界（包含）
         * @param inR 中序遍历数组的右边界（不包含）
         * @return 创建的二叉树
         */
        private TreeNode buildTree(int[] preorder, HashMap<Integer, Integer> posInInorder, int preL, int preR, int inL, int inR) {
            int rootVal = preorder[preL];
            int rootPos = posInInorder.get(rootVal);
            int leftTreeSize = rootPos - inL, rightTreeSize = inR - rootPos - 1;
            TreeNode root = new TreeNode(rootVal);
            if (leftTreeSize > 0) {
                root.left = buildTree(preorder, posInInorder, preL + 1, preL + 1 + leftTreeSize, inL, rootPos);
            }
            if (rightTreeSize > 0) {
                root.right = buildTree(preorder, posInInorder, preR - rightTreeSize, preR, rootPos + 1, inR);
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}