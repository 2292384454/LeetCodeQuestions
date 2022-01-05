package leetcode.editor.cn;
//Java：合并多棵二叉搜索树

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * <p>给你 <code>n</code> 个 <strong>二叉搜索树的根节点</strong> ，存储在数组 <code>trees</code> 中（<strong>下标从 0 开始</strong>），对应 <code>n</code> 棵不同的二叉搜索树。<code>trees</code> 中的每棵二叉搜索树 <strong>最多有 3 个节点</strong> ，且不存在值相同的两个根节点。在一步操作中，将会完成下述步骤：</p>
 *
 * <ul>
 * <li>选择两个 <strong>不同的</strong> 下标 <code>i</code> 和 <code>j</code> ，要求满足在 <code>trees[i]</code> 中的某个 <strong>叶节点</strong> 的值等于 <code>trees[j]</code> 的 <strong>根节点的值</strong> 。</li>
 * <li>用 <code>trees[j]</code> 替换 <code>trees[i]</code> 中的那个叶节点。</li>
 * <li>从 <code>trees</code> 中移除 <code>trees[j]</code> 。</li>
 * </ul>
 *
 * <p>如果在执行 <code>n - 1</code> 次操作后，能形成一棵有效的二叉搜索树，则返回结果二叉树的 <strong>根节点</strong> ；如果无法构造一棵有效的二叉搜索树<em>，</em>返回<em> </em><code>null</code> 。</p>
 *
 * <p>二叉搜索树是一种二叉树，且树中每个节点均满足下述属性：</p>
 *
 * <ul>
 * <li>任意节点的左子树中的值都 <strong>严格小于</strong> 此节点的值。</li>
 * <li>任意节点的右子树中的值都 <strong>严格大于</strong> 此节点的值。</li>
 * </ul>
 *
 * <p>叶节点是不含子节点的节点。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/06/08/d1.png" style="width: 450px; height: 163px;" />
 * <pre>
 * <strong>输入：</strong>trees = [[2,1],[3,2,5],[5,4]]
 * <strong>输出：</strong>[3,2,5,1,null,4]
 * <strong>解释：</strong>
 * 第一步操作中，选出 i=1 和 j=0 ，并将 trees[0] 合并到 trees[1] 中。
 * 删除 trees[0] ，trees = [[3,2,5,1],[5,4]] 。
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/06/24/diagram.png" style="width: 450px; height: 181px;" />
 * 在第二步操作中，选出 i=0 和 j=1 ，将 trees[1] 合并到 trees[0] 中。
 * 删除 trees[1] ，trees = [[3,2,5,1,null,4]] 。
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/06/24/diagram-2.png" style="width: 220px; height: 165px;" />
 * 结果树如上图所示，为一棵有效的二叉搜索树，所以返回该树的根节点。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/06/08/d2.png" style="width: 450px; height: 171px;" />
 * <pre>
 * <strong>输入：</strong>trees = [[5,3,8],[3,2,6]]
 * <strong>输出：</strong>[]
 * <strong>解释：</strong>
 * 选出 i=0 和 j=1 ，然后将 trees[1] 合并到 trees[0] 中。
 * 删除 trees[1] ，trees = [[5,3,8,2,6]] 。
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/06/24/diagram-3.png" style="width: 240px; height: 196px;" />
 * 结果树如上图所示。仅能执行一次有效的操作，但结果树不是一棵有效的二叉搜索树，所以返回 null 。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/06/08/d3.png" style="width: 430px; height: 168px;" />
 * <pre>
 * <strong>输入：</strong>trees = [[5,4],[3]]
 * <strong>输出：</strong>[]
 * <strong>解释：</strong>无法执行任何操作。
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/06/08/d4.png" style="width: 250px; height: 158px;" />
 * <pre>
 * <strong>输入：</strong>trees = [[2,1,3]]
 * <strong>输出：</strong>[2,1,3]
 * <strong>解释：</strong>trees 中只有一棵树，且这棵树已经是一棵有效的二叉搜索树，所以返回该树的根节点。
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>n == trees.length</code></li>
 * <li><code>1 <= n <= 5 * 10<sup>4</sup></code></li>
 * <li>每棵树中节点数目在范围 <code>[1, 3]</code> 内。</li>
 * <li>输入数据的每个节点可能有子节点但不存在子节点的子节点</li>
 * <li><code>trees</code> 中不存在两棵树根节点值相同的情况。</li>
 * <li>输入中的所有树都是 <strong>有效的二叉树搜索树</strong> 。</li>
 * <li><code>1 <= TreeNode.val <= 5 * 10<sup>4</sup></code>.</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>哈希表</li><li>二分查找</li><li>二叉树</li></div></div><p><div><li>👍 6</li><li>👎 0</li></div>
 */
public class P1932MergeBstsToCreateSingleBst {
    public static void main(String[] args) {
        Solution solution = new P1932MergeBstsToCreateSingleBst().new Solution();
        // TO TEST
        // TreeNode tree0 = TreeNode.constructTree(new Integer[]{2, 1});
        // TreeNode tree1 = TreeNode.constructTree(new Integer[]{3, 2, 5});
        // TreeNode tree2 = TreeNode.constructTree(new Integer[]{5, 4});
        // List<TreeNode> trees = Arrays.asList(tree0, tree1, tree2);
        TreeNode tree0 = TreeNode.constructTree(new Integer[]{2, 1});
        TreeNode tree1 = TreeNode.constructTree(new Integer[]{1, null, 3});
        TreeNode tree2 = TreeNode.constructTree(new Integer[]{3, 2});
        List<TreeNode> trees = Arrays.asList(tree0, tree1, tree2);

        System.out.println(solution.canMerge(trees));
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
        // 存储所有叶节点值的哈希集合
        HashSet<Integer> leaves = new HashSet<>();
        // 存储 (根节点值, 树) 键值对的哈希映射
        HashMap<Integer, TreeNode> candidates = new HashMap<>();
        // 在中序遍历中存储中序遍历上一个遍历到的值，便于检查严格单调性
        int prev = 0;

        public TreeNode canMerge(List<TreeNode> trees) {
            for (TreeNode tree : trees) {
                if (tree.left != null) {
                    leaves.add(tree.left.val);
                }
                if (tree.right != null) {
                    leaves.add(tree.right.val);
                }
                candidates.put(tree.val, tree);
            }
            for (TreeNode tree : trees) {
                // 寻找合并完成后的树的根节点
                if (!leaves.contains(tree.val)) {
                    // 将其从哈希映射中移除
                    candidates.remove(tree.val);
                    // 从根节点开始进行遍历
                    // 如果中序遍历有严格单调性，并且所有树的根节点都被遍历到，说明可以构造二叉搜索树
                    prev = 0;
                    return (dfs(tree) && candidates.isEmpty()) ? tree : null;
                }
            }
            return null;
        }

        // 中序遍历，返回值表示是否有严格单调性
        private boolean dfs(TreeNode tree) {
            if (tree == null) {
                return true;
            }
            // 如果遍历到叶节点，并且存在可以合并的树，那么就进行合并
            if (tree.left == null && tree.right == null && candidates.containsKey(tree.val)) {
                tree.left = candidates.get(tree.val).left;
                tree.right = candidates.get(tree.val).right;
                // 合并完成后，将树从哈希映射中移除，以便于在遍历结束后判断是否所有树都被遍历过
                candidates.remove(tree.val);
            }

            // 先遍历左子树
            if (!dfs(tree.left)) {
                return false;
            }
            // 再遍历当前节点
            if (tree.val <= prev) {
                return false;
            }
            prev = tree.val;
            // 最后遍历右子树
            return dfs(tree.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}