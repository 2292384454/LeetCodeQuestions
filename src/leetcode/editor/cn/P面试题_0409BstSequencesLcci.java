package leetcode.editor.cn;
//Java：二叉搜索树序列

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例：</strong><br>
 * 给定如下二叉树</p>
 *
 * <pre>        2
 * / \
 * 1   3
 * </pre>
 *
 * <p>返回：</p>
 *
 * <pre>[
 * [2,1,3],
 * [2,3,1]
 * ]
 * </pre>
 * <div><div>Related Topics</div><div><li>树</li><li>二叉搜索树</li><li>动态规划</li><li>二叉树</li></div></div><p><div><li>👍 65</li><li>👎 0</li></div>
 */
public class P面试题_0409BstSequencesLcci {
    public static void main(String[] args) {
        Solution solution = new P面试题_0409BstSequencesLcci().new Solution();
        // TO TEST
        TreeNode root = TreeNode.constructTree(new Integer[]{12, 5, 19, 2, 9, 15, null, null, null, null, null, 13, 17});
        List<List<Integer>> ans = solution.BSTSequences(root);
        System.out.println(ans);
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
        private List<List<Integer>> ans;

        public List<List<Integer>> BSTSequences(TreeNode root) {
            // 核心思想：每一个节点都必须排在它的子孙结点前面.
            ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            // 如果 root==null 返回 [[]]
            if (root == null) {
                ans.add(path);
                return ans;
            }
            List<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            // 开始进行回溯
            bfs(queue, path);
            return ans;
        }

        /**
         * 回溯法+广度优先遍历.
         */
        private void bfs(List<TreeNode> queue, List<Integer> path) {
            // queue 为空说明遍历完了，可以返回了
            if (queue.isEmpty()) {
                ans.add(new ArrayList<>(path));
                return;
            }
            // 将 queue 拷贝一份，用于稍后回溯
            List<TreeNode> copy = new ArrayList<>(queue);
            int size = queue.size();
            // 对 queue 进行循环，每循环考虑 “是否 「将当前 cur 节点从 queue 中取出并将其左右子
            // 节点加入 queue ，然后将 cur.val 加入到 path 末尾」 ” 的情况进行回溯
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.get(i);
                path.add(cur.val);
                queue.remove(i);
                // 将左右子节点加入队列
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                bfs(queue, path);
                // 恢复 path 和 queue ，进行回溯
                path.remove(path.size() - 1);
                queue = new ArrayList<>(copy);

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}