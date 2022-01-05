package leetcode.editor.cn;
//Java：删除系统中的重复文件夹

import java.util.*;

/**
 * <p>由于一个漏洞，文件系统中存在许多重复文件夹。给你一个二维数组 <code>paths</code>，其中 <code>paths[i]</code> 是一个表示文件系统中第 <code>i</code> 个文件夹的绝对路径的数组。</p>
 *
 * <ul>
 * <li>例如，<code>["one", "two", "three"]</code> 表示路径 <code>"/one/two/three"</code> 。</li>
 * </ul>
 *
 * <p>如果两个文件夹（不需要在同一层级）包含 <strong>非空且</strong><b>相同的&nbsp;</b>子文件夹&nbsp;<strong>集合</strong> 并具有相同的子文件夹结构，则认为这两个文件夹是相同文件夹。相同文件夹的根层级 <strong>不</strong> 需要相同。如果存在两个（或两个以上）<strong>相同</strong> 文件夹，则需要将这些文件夹和所有它们的子文件夹 <strong>标记</strong> 为待删除。</p>
 *
 * <ul>
 * <li>例如，下面文件结构中的文件夹 <code>"/a"</code> 和 <code>"/b"</code> 相同。它们（以及它们的子文件夹）应该被 <strong>全部</strong> 标记为待删除：
 *
 * <ul>
 * <li><code>/a</code></li>
 * <li><code>/a/x</code></li>
 * <li><code>/a/x/y</code></li>
 * <li><code>/a/z</code></li>
 * <li><code>/b</code></li>
 * <li><code>/b/x</code></li>
 * <li><code>/b/x/y</code></li>
 * <li><code>/b/z</code></li>
 * </ul>
 * </li>
 * <li>然而，如果文件结构中还包含路径 <code>"/b/w"</code> ，那么文件夹 <code>"/a"</code> 和 <code>"/b"</code> 就不相同。注意，即便添加了新的文件夹 <code>"/b/w"</code> ，仍然认为 <code>"/a/x"</code> 和 <code>"/b/x"</code> 相同。</li>
 * </ul>
 *
 * <p>一旦所有的相同文件夹和它们的子文件夹都被标记为待删除，文件系统将会 <strong>删除</strong> 所有上述文件夹。文件系统只会执行一次删除操作。执行完这一次删除操作后，不会删除新出现的相同文件夹。</p>
 *
 * <p>返回二维数组<em> </em><code>ans</code> ，该数组包含删除所有标记文件夹之后剩余文件夹的路径。路径可以按 <strong>任意顺序</strong> 返回。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/07/19/lc-dupfolder1.jpg" style="width: 200px; height: 218px;" />
 * <pre>
 * <strong>输入：</strong>paths = [["a"],["c"],["d"],["a","b"],["c","b"],["d","a"]]
 * <strong>输出：</strong>[["d"],["d","a"]]
 * <strong>解释：</strong>文件结构如上所示。
 * 文件夹 "/a" 和 "/c"（以及它们的子文件夹）都会被标记为待删除，因为它们都包含名为 "b" 的空文件夹。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/07/19/lc-dupfolder2.jpg" style="width: 200px; height: 355px;" />
 * <pre>
 * <strong>输入：</strong>paths = [["a"],["c"],["a","b"],["c","b"],["a","b","x"],["a","b","x","y"],["w"],["w","y"]]
 * <strong>输出：</strong>[["c"],["c","b"],["a"],["a","b"]]
 * <strong>解释：</strong>文件结构如上所示。
 * 文件夹 "/a/b/x" 和 "/w"（以及它们的子文件夹）都会被标记为待删除，因为它们都包含名为 "y" 的空文件夹。
 * 注意，文件夹 "/a" 和 "/c" 在删除后变为相同文件夹，但这两个文件夹不会被删除，因为删除只会进行一次，且它们没有在删除前被标记。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/07/19/lc-dupfolder3.jpg" style="width: 200px; height: 201px;" />
 * <pre>
 * <strong>输入：</strong>paths = [["a","b"],["c","d"],["c"],["a"]]
 * <strong>输出：</strong>[["c"],["c","d"],["a"],["a","b"]]
 * <strong>解释：</strong>文件系统中所有文件夹互不相同。
 * 注意，返回的数组可以按不同顺序返回文件夹路径，因为题目对顺序没有要求。
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/07/19/lc-dupfolder4_.jpg" style="width: 300px; height: 290px;" />
 * <pre>
 * <strong>输入：</strong>paths = [["a"],["a","x"],["a","x","y"],["a","z"],["b"],["b","x"],["b","x","y"],["b","z"]]
 * <strong>输出：</strong>[]
 * <strong>解释：</strong>文件结构如上所示。
 * 文件夹 "/a/x" 和 "/b/x"（以及它们的子文件夹）都会被标记为待删除，因为它们都包含名为 "y" 的空文件夹。
 * 文件夹 "/a" 和 "/b"（以及它们的子文件夹）都会被标记为待删除，因为它们都包含一个名为 "z" 的空文件夹以及上面提到的文件夹 "x" 。
 * </pre>
 *
 * <p><strong>示例 5：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/07/19/lc-dupfolder5_.jpg" style="width: 300px; height: 282px;" />
 * <pre>
 * <strong>输入：</strong>paths = [["a"],["a","x"],["a","x","y"],["a","z"],["b"],["b","x"],["b","x","y"],["b","z"],["b","w"]]
 * <strong>输出：</strong>[["b"],["b","w"],["b","z"],["a"],["a","z"]]
 * <strong>解释：</strong>本例与上例的结构基本相同，除了新增 "/b/w" 文件夹。
 * 文件夹 "/a/x" 和 "/b/x" 仍然会被标记，但 "/a" 和 "/b" 不再被标记，因为 "/b" 中有名为 "w" 的空文件夹而 "/a" 没有。
 * 注意，"/a/z" 和 "/b/z" 不会被标记，因为相同子文件夹的集合必须是非空集合，但这两个文件夹都是空的。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= paths.length &lt;= 2 * 10<sup>4</sup></code></li>
 * <li><code>1 &lt;= paths[i].length &lt;= 500</code></li>
 * <li><code>1 &lt;= paths[i][j].length &lt;= 10</code></li>
 * <li><code>1 &lt;= sum(paths[i][j].length) &lt;= 2 * 10<sup>5</sup></code></li>
 * <li><code>path[i][j]</code> 由小写英文字母组成</li>
 * <li>不会存在两个路径都指向同一个文件夹的情况</li>
 * <li>对于不在根层级的任意文件夹，其父文件夹也会包含在输入中</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>字典树</li><li>数组</li><li>哈希表</li><li>字符串</li><li>哈希函数</li></div></div><p><div><li>👍 10</li><li>👎 0</li></div>
 */
public class P1948DeleteDuplicateFoldersInSystem {
    public static void main(String[] args) {
        Solution solution = new P1948DeleteDuplicateFoldersInSystem().new Solution();
        // TO TEST
        List<List<String>> paths = new ArrayList<>();
        paths.add(Arrays.asList("a"));
        paths.add(Arrays.asList("a", "x"));
        paths.add(Arrays.asList("a", "x", "y"));
        paths.add(Arrays.asList("a", "z"));
        paths.add(Arrays.asList("b"));
        paths.add(Arrays.asList("b", "x"));
        paths.add(Arrays.asList("b", "x", "y"));
        paths.add(Arrays.asList("b", "z"));

        System.out.println(solution.deleteDuplicateFolder(paths));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
            // 构建前缀树
            Node root = new Node();
            for (List<String> path : paths) {
                Node node = root;
                for (String s : path) {
                    node = node.nextMap.computeIfAbsent(s, t -> new Node());
                }
            }

            // 对前缀树的所有节点进行标记，判断子树是否相等
            tagDupFolderByDfs(root, new HashMap<>());
            ArrayList<List<String>> resList = new ArrayList<>();
            // 结果入栈
            deleteDuplicateFolder(root, new ArrayList<>(), resList);
            return resList;
        }

        // 对前缀树的所有节点进行标记，判断子树是否相等
        private int tagDupFolderByDfs(Node root, HashMap<Integer, ArrayList<Node>> map) {
            int hash = Objects.hash();
            for (Map.Entry<String, Node> entry : root.nextMap.entrySet()) {
                // 求当前节点的hash值，记录了当前节点为头的所有子树节点的信息
                hash = Objects.hash(hash, entry.getKey(), tagDupFolderByDfs(entry.getValue(), map));
            }

            // 标记hash值相等的节点
            if (!root.nextMap.isEmpty()) {
                for (Node node : map.getOrDefault(hash, new ArrayList<>())) {
                    if (root.equals(node)) {
                        root.mark = node.mark = true;
                        break;
                    }
                }
            }

            // 将hash值相等的节点存入同一个list中
            map.computeIfAbsent(hash, t -> new ArrayList<>()).add(root);
            return hash;
        }

        // 统计结果，删除所有标记为true的节点及其子树
        private void deleteDuplicateFolder(Node root, ArrayList<String> stack, ArrayList<List<String>> resList) {
            if (!root.mark) {
                if (!stack.isEmpty()) {
                    resList.add(new ArrayList<>(stack));
                }

                for (Map.Entry<String, Node> entry : root.nextMap.entrySet()) {
                    stack.add(entry.getKey());
                    deleteDuplicateFolder(entry.getValue(), stack, resList);
                    stack.remove(stack.size() - 1);
                }
            }
        }

        // 前缀树节点
        private class Node {
            // TreeMap存储节点所有分支，这样最后统计结果时会按字典序进行排列
            private TreeMap<String, Node> nextMap;
            // 标记为true则代表，节点为头的子树存在重复，需要删除
            private boolean mark;

            public Node() {
                this.nextMap = new TreeMap<>();
                this.mark = false;
            }

            // 自定义判断节点是否相等的规则，即以当前节点为头的子树分支路径必须完全相等
            public boolean equals(Node node) {
                if (!nextMap.keySet().equals(node.nextMap.keySet())) {
                    return false;
                }
                for (Map.Entry<String, Node> entry : nextMap.entrySet()) {
                    if (!entry.getValue().equals(node.nextMap.get(entry.getKey()))) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}