//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 设计 
// 👍 165 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：序列化二叉树
public class P剑指_offer_37XuLieHuaErChaShuLcof {
    public static void main(String[] args) {
        Codec solution = new P剑指_offer_37XuLieHuaErChaShuLcof().new Codec();
        // TO TEST
        String data = "[1,2,3,null,null,4,5]";
        System.out.println();
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
            if (root == null) return null;
            String ans = "[";
            LinkedList<String> array = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    array.add(String.valueOf(node.val));
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    array.add("null");
                }
            }
            while (("null").equals(array.getLast())) {
                array.removeLast();
            }
            ans += String.join(",", array);
            ans += "]";
            System.out.println(ans);
            return ans;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null) return null;
            TreeNode root;
            // 将字符串重新转换成 Integer 数组 nums
            String[] strings = data.substring(1, data.length() - 1).split(",");
            Integer[] array = new Integer[strings.length];
            for (int i = 0; i < strings.length; i++) {
                try {
                    array[i] = Integer.parseInt(strings[i]);
                } catch (NumberFormatException ignored) {
                }
            }
            if (array.length == 0) {
                return null;
            }
            Queue<Integer> nums = new LinkedList<>(Arrays.asList(array));
            Queue<TreeNode> queue = new LinkedList<>();
            // 创建一个根节点
            root = new TreeNode(nums.remove());
            queue.add(root);
            TreeNode cur;
            // 记录当前行节点的数量（注意不一定是2的幂，而是上一行中非空节点的数量乘2）
            int lineNodeNum = 2;
            // 记录当前行中数字在数组中的开始位置
            int startIndex = 1;
            while (!nums.isEmpty()) {
                // 只有最后一行可以不满，其余行必须是满的
                for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2) {
                    cur = queue.remove();
                    for (int j = 0; j < 2; j++) {
                        if (nums.isEmpty()) {
                            return root;
                        }
                        Integer val = nums.remove();
                        if (j == 0 && val != null) {
                            cur.left = new TreeNode(val);
                            queue.add(cur.left);
                        } else if (val != null) {
                            cur.right = new TreeNode(val);
                            queue.add(cur.right);
                        }
                    }
                }
                startIndex += lineNodeNum;
                lineNodeNum = queue.size() * 2;
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}