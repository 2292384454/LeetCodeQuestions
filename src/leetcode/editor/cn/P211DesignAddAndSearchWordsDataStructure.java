//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。 
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '
//.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search","se
//arch"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 500 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 50000 次 addWord 和 search 
// 
// Related Topics 深度优先搜索 设计 字典树 回溯算法 
// 👍 241 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java：添加与搜索单词 - 数据结构设计
public class P211DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new P211DesignAddAndSearchWordsDataStructure().new WordDictionary();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {
        Node root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node parent = root;
            for (char c : word.toCharArray()) {
                if (parent.next.get(c) == null) {
                    parent.next.put(c, new Node());
                }
                parent = parent.next.get(c);
            }
            parent.isEnd = true;
        }

        public boolean search(String word) {
            return DFS(word, root);
        }

        private boolean DFS(String word, Node root) {
            if (word.length() == 0) {
                return root.isEnd;
            }
            char c = word.charAt(0);
            String subStr = word.substring(1);
            if (c != '.' && root.next.get(c) == null) {
                return false;
            } else if (c == '.') {
                for (Node n : root.next.values()) {
                    if (DFS(subStr, n)) {
                        return true;
                    }
                }
            } else {
                return DFS(subStr, root.next.get(c));
            }
            return false;
        }

        private class Node {
            HashMap<Character, Node> next;//next节点
            boolean isEnd = false;//记录节点是不是某个字符串的最后一个字符

            private Node() {
                next = new HashMap<>();
            }
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
