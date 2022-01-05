//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;

//Java：相同的树
public class P100SameTree {
    public static void main(String[] args) {
        Solution solution = new P100SameTree().new Solution();
        // TO TEST
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.left.left = new TreeNode(3);

        System.out.println(solution.isSameTree(t1, t2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
