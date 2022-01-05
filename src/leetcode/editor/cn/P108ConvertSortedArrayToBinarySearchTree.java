//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;

import java.util.Arrays;

//Java：将有序数组转换为二叉搜索树
public class P108ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P108ConvertSortedArrayToBinarySearchTree().new Solution();
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
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums.length == 0) {
                return null;//如果数组为空，返回空树
            }
            int left = 0, right = nums.length, mid = (left + right) / 2;//按照二分查找的办法遍历数组
            TreeNode root = new TreeNode(nums[mid]), p = root;//数组中间的那个元素作为根节点
            if (left < right) {//如果left小于right开始递归，给root添加左子树和右子树
                //把中间元素左边的数组部分送入递归，返回结果作为左子树
                root.left = sortedArrayToBST(Arrays.copyOfRange(nums, left, mid));
                //把中间元素左边的数组部分送入递归，返回结果作为右子树
                root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, right));
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}