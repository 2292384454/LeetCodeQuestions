package leetcode.editor.cn;
//Java：文件的最长绝对路径

import java.util.*;

/**
 * <p>假设文件系统如下图所示：</p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mdir.jpg" style="width: 681px; height: 322px;" /></p>
 *
 * <p>这里将 <code>dir</code> 作为根目录中的唯一目录。<code>dir</code> 包含两个子目录 <code>subdir1</code> 和 <code>subdir2</code> 。<code>subdir1</code> 包含文件 <code>file1.ext</code> 和子目录 <code>subsubdir1</code>；<code>subdir2</code> 包含子目录 <code>subsubdir2</code>，该子目录下包含文件 <code>file2.ext</code> 。</p>
 *
 * <p>在文本格式中，如下所示(⟶表示制表符)：</p>
 *
 * <pre>
 * dir
 * ⟶ subdir1
 * ⟶ ⟶ file1.ext
 * ⟶ ⟶ subsubdir1
 * ⟶ subdir2
 * ⟶ ⟶ subsubdir2
 * ⟶ ⟶ ⟶ file2.ext
 * </pre>
 *
 * <p>如果是代码表示，上面的文件系统可以写为 <code>"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"</code> 。<code>'\n'</code> 和 <code>'\t'</code> 分别是换行符和制表符。</p>
 *
 * <p>文件系统中的每个文件和文件夹都有一个唯一的 <strong>绝对路径</strong> ，即必须打开才能到达文件/目录所在位置的目录顺序，所有路径用 <code>'/'</code> 连接。上面例子中，指向 <code>file2.ext</code> 的绝对路径是 <code>"dir/subdir2/subsubdir2/file2.ext"</code> 。每个目录名由字母、数字和/或空格组成，每个文件名遵循 <code>name.extension</code> 的格式，其中名称和扩展名由字母、数字和/或空格组成。</p>
 *
 * <p>给定一个以上述格式表示文件系统的字符串 <code>input</code> ，返回文件系统中 <strong>指向文件的最长绝对路径</strong> 的长度。 如果系统中没有文件，返回 <code>0</code>。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/dir1.jpg" style="width: 401px; height: 202px;" />
 * <pre>
 * <strong>输入：</strong>input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
 * <strong>输出：</strong>20
 * <strong>解释：</strong>只有一个文件，绝对路径为 "dir/subdir2/file.ext" ，路径长度 20
 * 路径 "dir/subdir1" 不含任何文件
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/dir2.jpg" style="width: 641px; height: 322px;" />
 * <pre>
 * <strong>输入：</strong>input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 * <strong>输出：</strong>32
 * <strong>解释：</strong>存在两个文件：
 * "dir/subdir1/file1.ext" ，路径长度 21
 * "dir/subdir2/subsubdir2/file2.ext" ，路径长度 32
 * 返回 32 ，因为这是最长的路径</pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>input = "a"
 * <strong>输出：</strong>0
 * <strong>解释：</strong>不存在任何文件</pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>input = "file1.txt\nfile2.txt\nlongfile.txt"
 * <strong>输出：</strong>12
 * <strong>解释：</strong>根目录下有 3 个文件。
 * 因为根目录中任何东西的绝对路径只是名称本身，所以答案是 "longfile.txt" ，路径长度为 12
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= input.length <= 10<sup>4</sup></code></li>
 * <li><code>input</code> 可能包含小写或大写的英文字母，一个换行符 <code>'\n'</code>，一个指表符 <code>'\t'</code>，一个点 <code>'.'</code>，一个空格 <code>' '</code>，和数字。</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>栈</li><li>深度优先搜索</li><li>字符串</li></div></div><p><div><li>👍 82</li><li>👎 0</li></div>
 */
public class P388LongestAbsoluteFilePath {
    public static void main(String[] args) {
        Solution solution = new P388LongestAbsoluteFilePath().new Solution();
        // TO TEST
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(solution.lengthLongestPath(input));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 文件树结点
     */
    class FileNode {
        /**
         * 文件名
         */
        String name;
        /**
         * 子目录
         */
        List<FileNode> children = new ArrayList<>();
        /**
         * 深度
         */
        int depth;
        /**
         * 是否为文件
         */
        boolean isFile;

        /**
         * 构造方法
         */
        public FileNode(String name, int depth, boolean isFile) {
            this.name = name;
            this.depth = depth;
            this.isFile = isFile;
        }

        /**
         * 添加子目录
         */
        public void addChild(FileNode child) {
            children.add(child);
        }
    }

    class Solution {
        public int lengthLongestPath(String input) {
            //  构造文件树
            FileNode root = buildTree(input);
            // 深度优先遍历
            return Math.max(0, dfs(root) - 5);
        }

        /**
         * 构造文件树，文件树固定有一个根节点 root
         */
        private FileNode buildTree(String input) {
            String[] array = input.split("\n");
            Deque<FileNode> stack = new LinkedList<>();
            // 根目录
            FileNode root = new FileNode("root", -1, false);
            stack.push(root);
            for (String str : array) {
                int depth = 0;
                // str 中 '\t' 的数量就是其深度
                while (depth < str.length() && str.charAt(depth) == '\t') {
                    depth++;
                }
                String name = str.substring(depth);
                boolean isFile = str.contains(".");
                // 构造节点
                FileNode cur = new FileNode(name, depth, isFile);
                // 从 stack 中找到 cur 的父节点
                while (stack.peek().depth >= depth) {
                    stack.pop();
                }
                stack.peek().addChild(cur);
                stack.push(cur);
            }
            return root;
        }

        /**
         * 对文件树深度优先遍历，返回文件的最长绝对路径，如果没有文件就会返回负值
         */
        private int dfs(FileNode root) {
            int len = root.name.length();
            if (root.isFile) {
                // 叶子结点是 文件
                return len;
            } else if (root.children.size() == 0) {
                // 叶子结点是 目录，返回 Integer.MIN_VALUE
                return Integer.MIN_VALUE;
            }
            int temp = Integer.MIN_VALUE;
            for (FileNode child : root.children) {
                temp = Math.max(temp, dfs(child));
            }
            return temp + len + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}