//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 484 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java：从中序与后序遍历序列构造二叉树
public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        // TO TEST
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        System.out.println(solution.buildTree(inorder, postorder));
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
        int[] inorder;
        int[] postorder;
        //存储中序遍历数组中节点值和索引的对应关系
        public HashMap<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.inorder = inorder;
            this.postorder = postorder;

            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(0, 0, postorder.length);
        }

        public TreeNode buildTree(int in_start, int post_start, int post_end) {
            if (post_end <= post_start) {
                return null;
            }
            int rootVal = postorder[post_end - 1];//根节点值是后续遍历数组中最后一个
            TreeNode root = new TreeNode(rootVal);//创建根节点
            int rootIndexInInorder = map.get(rootVal);//根节点值在中序遍历数组中的索引
            int leftTreeSize = rootIndexInInorder - in_start;//计算root的左、右子树的节点数量
            root.left = buildTree(in_start, post_start, post_start + leftTreeSize);
            root.right = buildTree(rootIndexInInorder + 1, post_start + leftTreeSize, post_end - 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
