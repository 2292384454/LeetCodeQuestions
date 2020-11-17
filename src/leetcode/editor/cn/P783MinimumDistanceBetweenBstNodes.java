//给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。 
//
// 
//
// 示例： 
//
// 输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树节点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \    
//    1   3  
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。 
//
// 
//
// 注意： 
//
// 
// 二叉树的大小范围在 2 到 100。 
// 二叉树总是有效的，每个节点的值都是整数，且不重复。 
// 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 
//相同 
// 
// Related Topics 树 递归 
// 👍 96 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//Java：二叉搜索树节点最小距离
public class P783MinimumDistanceBetweenBstNodes {
    public static void main(String[] args) {
        Solution solution = new P783MinimumDistanceBetweenBstNodes().new Solution();
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
        public int minDiffInBST(TreeNode root) {
            //非递归中序遍历
            int min = Integer.MAX_VALUE, top = -1;//，min为最终要返回的结果，top为栈顶指针
            //pre指向上一次遍历的结点，p为循环指针，mystack用数组构成一个顺序栈，用来进行中序遍历
            TreeNode pre = null, p = root, mystack[] = new TreeNode[100];
            while (top != -1 || p != null) {
                while (p != null) {
                    mystack[++top] = p;
                    p = p.left;
                }
                if (top != -1) {
                    p = mystack[top--];
                    if (pre != null)
                        min = Math.min(min, p.val - pre.val);
                    pre = p;
                    p = p.right;
                }
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}