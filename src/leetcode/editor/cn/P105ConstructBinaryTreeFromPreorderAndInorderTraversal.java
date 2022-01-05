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
        //成员变量
        int[] preorder;
        int[] inorder;
        //存储中序遍历数组中节点值和索引的对应关系
        public HashMap<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;
            //map中存储inorder数组中的数和索引的映射关系
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTreeHelper(0, preorder.length, 0);
        }

        private TreeNode buildTreeHelper(int pre_start, int pre_end, int in_start) {
            if (pre_start >= pre_end) {
                return null;
            }
            //先序遍历数组有效部分的第一个数就是二叉树的根节点的值
            int root_val = preorder[pre_start];
            TreeNode root = new TreeNode(root_val);
            //找到中序遍历数组中根节点值的位置
            int rootIndexInInorder = map.get(root_val);
            //计算根节点左子树中结点的数量
            int leftSize = rootIndexInInorder - in_start;
            //递归构造左子树
            root.left = buildTreeHelper(pre_start + 1, pre_start + leftSize + 1, in_start);
            //递归构造右子树
            root.right = buildTreeHelper(pre_start + leftSize + 1, pre_end, rootIndexInInorder + 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
