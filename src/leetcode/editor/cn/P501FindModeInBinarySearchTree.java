//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 145 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;


//Java：二叉搜索树中的众数
public class P501FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P501FindModeInBinarySearchTree().new Solution();
        // TO TEST
        Integer strArray[] = {1, null, 2, 2, 3, null, 1, 2, 5};
        TreeNode root = TreeNode.constructTree(strArray);
        System.out.println(solution.findMode(root));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        private int curTimes, maxTimes, curVal;
        ArrayList<Integer> modes = new ArrayList<>();

        public int[] findMode(TreeNode root) {
            inOrder(root);
            Integer[] resArray = modes.toArray(new Integer[0]);
            return Arrays.stream(resArray).mapToInt(Integer::valueOf).toArray();
        }

        //中序遍历
        public void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            //如果当前数字是第一个或者出现了一个新的数字
            if (curTimes == 0 || root.val != curVal) {
                curTimes = 1;//当前数字出现的次数置1
                curVal = root.val;//更新当前记录值
            } else {
                ++curTimes;
            }
            if (curTimes == maxTimes) {
                modes.add(curVal);
            }
            if (curTimes > maxTimes) {
                maxTimes = curTimes;
                modes.clear();
                modes.add(curVal);
            }
            inOrder(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}