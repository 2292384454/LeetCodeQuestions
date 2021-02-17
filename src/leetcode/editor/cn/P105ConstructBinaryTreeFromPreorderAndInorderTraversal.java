//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
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
// Related Topics 树 深度优先搜索 数组 
// 👍 848 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java：从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            //map中存储inorder数组中的数和索引的映射关系
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++)
                map.put(inorder[i], i);
            return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
        }

        /**
         * @param preorder 先序遍历数组
         * @param p_start  先序遍历数组起始位置
         * @param p_end    先序遍历数组终止位置（不包含）
         * @param inorder  中序遍历数组
         * @param i_start  中序遍历数组起始位置
         * @param i_end    中序遍历数组终止位置（不包含）
         * @param map      中序遍历数组的数和索引的映射map
         * @return 返回构造的二叉树
         */
        private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end,
                                         HashMap<Integer, Integer> map) {
            //如果先序遍历数组长度为0，直接返回空二叉树
            if (p_start == p_end)
                return null;
            //先序遍历数组有效部分的第一个数就是二叉树的根节点的值
            int root_val = preorder[p_start];
            TreeNode root = new TreeNode(root_val);
            //找到中序遍历数组中根节点值的位置
            int i_root_index = map.get(root_val);
            //计算根节点左子树中结点的数量
            int leftNum = i_root_index - i_start;
            //递归构造左子树
            root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index, map);
            //递归构造右子树
            root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end, map);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
