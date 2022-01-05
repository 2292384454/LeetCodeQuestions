//请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。 
//
// 
//
// 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。 
//
// 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。 
//
// 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,nu
//ll,null,null,null,9,8]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root1 = [1], root2 = [1]
//输出：true
// 
//
// 示例 3： 
//
// 输入：root1 = [1], root2 = [2]
//输出：false
// 
//
// 示例 4： 
//
// 输入：root1 = [1,2], root2 = [2,2]
//输出：true
// 
//
// 示例 5： 
//
// 
//
// 输入：root1 = [1,2,3], root2 = [1,3,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 给定的两棵树可能会有 1 到 200 个结点。 
// 给定的两棵树上的值介于 0 到 200 之间。 
// 
// Related Topics 树 深度优先搜索 
// 👍 79 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//Java：叶子相似的树
public class P872LeafSimilarTrees {
    public static void main(String[] args) {
        Solution solution = new P872LeafSimilarTrees().new Solution();
        // TO TEST
        TreeNode root1 = TreeNode.constructTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4});
        TreeNode root2 = TreeNode.constructTree(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 11, null, null, 8, 10});
        System.out.println(solution.leafSimilar(root1, root2));
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
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            TreeNode p = root1, q = root2, leaf1 = null, leaf2 = null;
            Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack<>();
            //对root1进行中序遍历
            while (p != null || !stack1.isEmpty()) {
                while (p != null) {
                    stack1.add(p);
                    p = p.left;
                }
                p = stack1.pop();
                //当遍历到root1中的叶子结点时，去遍历root2，找到对应的叶子结点
                if (p.left == null && p.right == null) {
                    leaf1 = p;
                    while (q != null || !stack2.isEmpty()) {
                        while (q != null) {
                            stack2.add(q);
                            q = q.left;
                        }
                        q = stack2.pop();
                        //当遍历到root2的第一个叶子结点，比较leaf1是否等于leaf2
                        if (q.left == null && q.right == null) {
                            leaf2 = q;
                            //如果leaf1!=leaf2，返回false
                            if (leaf1.val != leaf2.val) {
                                return false;
                            } else {
                                //如果leaf1==leaf2，跳出对root2的遍历，下一次从本次跳出的位置开始遍历
                                q = q.right;
                                break;
                            }
                        }
                        q = q.right;
                    }
                }
                p = p.right;
            }
            //防止root2的叶子结点没有遍历完，如果root2还有叶子结点，那么说明root2的叶子结点比root1多，返回false
            while (q != null || !stack2.isEmpty()) {
                while (q != null) {
                    stack2.add(q);
                    q = q.left;
                }
                q = stack2.pop();
                if (q.left == null && q.right == null) {
                    return false;
                }
                q = q.right;
            }
            return leaf1.val == leaf2.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}