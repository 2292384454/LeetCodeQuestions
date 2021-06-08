//给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。 
//
// 案例 1: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 9
//
//输出: True
// 
//
// 
//
// 案例 2: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 28
//
//输出: False
// 
//
// 
// Related Topics 树 
// 👍 181 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;

//Java：两数之和 IV - 输入 BST
public class P653TwoSumIvInputIsABst {
    public static void main(String[] args) {
        Solution solution = new P653TwoSumIvInputIsABst().new Solution();
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
        public boolean findTarget(TreeNode root, int k) {
            ArrayList<Integer> valList = new ArrayList<>();
            valList = InOrderTraversal(root, valList);
            Integer valArray[] = valList.toArray(new Integer[valList.size()]);
            int left = 0, right = valArray.length - 1;
            while (left < right) {
                if (valArray[left] + valArray[right] == k) {
                    return true;
                } else if (valArray[left] + valArray[right] > k) {
                    right = right - 1;
                } else {
                    left = left + 1;
                }
            }
            return false;
        }

        public ArrayList<Integer> InOrderTraversal(TreeNode root, ArrayList<Integer> integerArrayList) {
            if (root != null) {
                InOrderTraversal(root.left, integerArrayList);
                integerArrayList.add(root.val);
                InOrderTraversal(root.right, integerArrayList);
            }
            return integerArrayList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}