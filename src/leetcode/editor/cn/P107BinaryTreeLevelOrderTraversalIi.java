//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索


package leetcode.editor.cn;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的层次遍历 II
public class P107BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new P107BinaryTreeLevelOrderTraversalIi().new Solution();
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            TreeNode p = root;//循环指针
            List<List<Integer>> result = new LinkedList<>();//要返回的结果列表
            Queue<TreeNode> myQueue = new LinkedList<TreeNode>();//辅助队列
            if (p == null) return result;//如果树为空就返回空表
            myQueue.offer(p);//将根节点入队
            while (!myQueue.isEmpty()) {//循环跳出条件为队空
                List<Integer> tempList = new ArrayList<>();//创建临时列表
                int len = myQueue.size();//记录下此时列表的长度
                for (int i = 0; i < len; i++) {//进行len次循环，刚好将本层元素的值全部出队并送入临时列表
                    p = myQueue.poll();//将队顶元素出队
                    tempList.add(p.val);//将队顶元素的值送入临时列表
                    if (p.left != null) myQueue.offer(p.left);//队顶元素左子节点入队
                    if (p.right != null) myQueue.offer(p.right);//队顶元素右子节点入队
                }
                result.add(0, tempList);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}