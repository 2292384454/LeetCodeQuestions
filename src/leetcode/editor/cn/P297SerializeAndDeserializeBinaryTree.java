package leetcode.editor.cn;
//Java：二叉树的序列化与反序列化

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。</p>
 *
 * <p>请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。</p>
 *
 * <p><strong>提示: </strong>输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 <a href="/faq/#binary-tree">LeetCode 序列化二叉树的格式</a>。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/serdeser.jpg" style="width: 442px; height: 324px;" />
 * <pre>
 * <strong>输入：</strong>root = [1,2,3,null,null,4,5]
 * <strong>输出：</strong>[1,2,3,null,null,4,5]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>root = []
 * <strong>输出：</strong>[]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>root = [1]
 * <strong>输出：</strong>[1]
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>root = [1,2]
 * <strong>输出：</strong>[1,2]
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>树中结点数在范围 <code>[0, 10<sup>4</sup>]</code> 内</li>
 * <li><code>-1000 <= Node.val <= 1000</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>设计</li><li>字符串</li><li>二叉树</li></div></div><p><div><li>👍 586</li><li>👎 0</li></div>
 */
public class P297SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        Codec codec = new P297SerializeAndDeserializeBinaryTree().new Codec();
        // TO TEST
        System.out.println(codec.deserialize("[]"));
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
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            ArrayList<Integer> array = new ArrayList<>();
            int end = -1;
            if (root != null) {
                Queue<TreeNode> q = new LinkedList<>();
                q.add(root);
                while (!q.isEmpty()) {
                    TreeNode node = q.poll();
                    if (node != null) {
                        array.add(node.val);
                    } else {
                        array.add(null);
                    }
                    if (node != null) {
                        q.add(node.left);
                        q.add(node.right);
                    }
                }
                end = array.size() - 1;
                while (array.get(end) == null) {
                    end -= 1;
                }
            }
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i <= end; i++) {
                sb.append(array.get(i));
                if (i < end) {
                    sb.append(',');
                }
            }
            sb.append("]");
            System.out.println(sb);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            // 先将字符串转成 Integer 数组
            String str = data.substring(1, data.length() - 1);
            if (str.length() == 0) {
                return null;
            }
            String[] s = str.split(",");
            Integer[] nums = new Integer[s.length];
            for (int i = 0; i < nums.length; i++) {
                try {
                    nums[i] = Integer.parseInt(s[i]);
                } catch (Exception ignored) {
                }
            }
            if (nums.length == 0) {
                return null;
            }
            // 层序遍历的思路
            Queue<TreeNode> q = new LinkedList<>();
            TreeNode root = new TreeNode(nums[0]);
            q.add(root);
            // 本行的节点数量（包括空节点）
            int countThisLine = 2;
            // 本行节点在数组中开始的位置
            int start = 1;
            while (start < nums.length && !q.isEmpty()) {
                for (int i = start; i < start + countThisLine; i += 2) {
                    TreeNode cur = q.poll();
                    if (cur == null) {
                        continue;
                    }
                    if (i >= nums.length) {
                        break;
                    }
                    TreeNode left = null;
                    if (nums[i] != null) {
                        left = new TreeNode(nums[i]);
                        q.add(left);
                    }
                    cur.left = left;

                    if (i + 1 >= nums.length) {
                        break;
                    }
                    TreeNode right = null;
                    if (nums[i + 1] != null) {
                        right = new TreeNode(nums[i + 1]);
                        q.add(right);
                    }
                    cur.right = right;
                }
                start += countThisLine;
                countThisLine *= 2;
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}