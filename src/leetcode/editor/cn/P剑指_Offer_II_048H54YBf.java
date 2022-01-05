package leetcode.editor.cn;
//Java：序列化与反序列化二叉树

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。</p>
 *
 * <p>请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/serdeser.jpg" style="width: 442px; height: 324px;" /></p>
 *
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
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅&nbsp;<a href="/faq/#binary-tree">LeetCode 序列化二叉树的格式</a>。你并非必须采取这种方式，也可以采用其他的方法解决这个问题。</li>
 * <li>树中结点数在范围 <code>[0, 10<sup>4</sup>]</code> 内</li>
 * <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 297&nbsp;题相同：<a href="https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/">https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/</a>&nbsp;</p>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>设计</li><li>字符串</li><li>二叉树</li></div></div><p><div><li>👍 1</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_048H54YBf {
    public static void main(String[] args) {
        Codec codec = new P剑指_Offer_II_048H54YBf().new Codec();
        // TO TEST
        String str = "[1, 2, 3, null, null, 4, 5]";
        TreeNode root = codec.deserialize(str);
        System.out.println(root);
        String data = codec.serialize(root);
        System.out.println(data);
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
            if (root == null) {
                return "[]";
            }
            List<String> strs = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                boolean allNull = true;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    strs.add(node == null ? "null" : node.val + "");
                    if (node != null) {
                        allNull = false;
                        queue.add(node.left);
                        queue.add(node.right);
                    }
                }
                if (allNull) {
                    break;
                }
            }
            int right = strs.size() - 1;
            while ("null".equals(strs.get(right))) {
                right--;
            }
            strs = strs.subList(0, right + 1);
            return strs.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("[]".equals(data)) {
                return null;
            }
            data = data.substring(1, data.length() - 1);
            String[] strArr = data.split(", ");
            if (strArr.length == 0 || "null".equals(strArr[0])) {
                return null;
            }
            int n = strArr.length;
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
            queue.add(root);
            int sizeOfThisLevel = 2;
            int startOfThisLeval = 1;
            int i = startOfThisLeval;
            while (i < n) {
                int newSize = 0;
                for (i = startOfThisLeval; i < n && i < startOfThisLeval + sizeOfThisLevel; i += 2) {
                    TreeNode node = queue.poll();
                    if (!"null".equals(strArr[i])) {
                        newSize += 2;
                        TreeNode newNode = new TreeNode(Integer.parseInt(strArr[i]));
                        node.left = newNode;
                        queue.add(newNode);
                    }
                    if (i + 1 < n && i + 1 < startOfThisLeval + sizeOfThisLevel && !"null".equals(strArr[i + 1])) {
                        newSize += 2;
                        TreeNode newNode = new TreeNode(Integer.parseInt(strArr[i + 1]));
                        node.right = newNode;
                        queue.add(newNode);
                    }
                }
                startOfThisLeval += sizeOfThisLevel;
                sizeOfThisLevel = newSize;
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}