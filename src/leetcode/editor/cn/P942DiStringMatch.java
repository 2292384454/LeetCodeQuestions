//给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。 
//
// 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有： 
//
// 
// 如果 S[i] == "I"，那么 A[i] < A[i+1] 
// 如果 S[i] == "D"，那么 A[i] > A[i+1] 
// 
//
// 
//
// 示例 1： 
//
// 输入："IDID"
//输出：[0,4,1,3,2]
// 
//
// 示例 2： 
//
// 输入："III"
//输出：[0,1,2,3]
// 
//
// 示例 3： 
//
// 输入："DDI"
//输出：[3,2,0,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 10000 
// S 只包含字符 "I" 或 "D"。 
// 
// Related Topics 数学 
// 👍 189 👎 0

package leetcode.editor.cn;

//Java：增减字符串匹配
public class P942DiStringMatch {
    public static void main(String[] args) {
        Solution solution = new P942DiStringMatch().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int val = 0;

        public int[] diStringMatch(String S) {
            BinaryNode root = new BinaryNode(0), p = root;
            int s_len = S.length(), index = 0;
            int[] result = new int[s_len + 1];
            for (int i = 0; i < s_len; i++) {
                if (S.charAt(i) == 'I') {
                    p.right = new BinaryNode(0);
                    p = p.right;
                }
                if (S.charAt(i) == 'D') {
                    p.left = new BinaryNode(0);
                    p = p.left;
                }
            }
            fill(root);
            p = root;
            while (p != null) {
                result[index++] = p.val;
                if (p.left != null) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
            return result;
        }

        private void fill(BinaryNode root) {
            if (root != null) {
                fill(root.left);
                root.val = val++;
                fill(root.right);
            }
        }
    }

    public class BinaryNode {
        int val;
        BinaryNode left;
        BinaryNode right;

        BinaryNode(int x) {
            val = x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
