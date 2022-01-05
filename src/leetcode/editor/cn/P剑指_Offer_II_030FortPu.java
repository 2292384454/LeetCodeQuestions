package leetcode.editor.cn;
//Java：插入、删除和随机访问都是 O(1) 的容器

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>设计一个支持在<em>平均&nbsp;</em>时间复杂度 <strong>O(1)</strong>&nbsp;下，执行以下操作的数据结构：</p>
 *
 * <ul>
 * <li><code>insert(val)</code>：当元素 <code>val</code> 不存在时返回 <code>true</code>&nbsp;，并向集合中插入该项，否则返回 <code>false</code> 。</li>
 * <li><code>remove(val)</code>：当元素 <code>val</code> 存在时返回 <code>true</code>&nbsp;，并从集合中移除该项，否则f返回 <code>true</code>&nbsp;。</li>
 * <li><code>getRandom</code>：随机返回现有集合中的一项。每个元素应该有&nbsp;<strong>相同的概率&nbsp;</strong>被返回。</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 :</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>inputs = [&quot;RandomizedSet&quot;, &quot;insert&quot;, &quot;remove&quot;, &quot;insert&quot;, &quot;getRandom&quot;, &quot;remove&quot;, &quot;insert&quot;, &quot;getRandom&quot;]
 * [[], [1], [2], [2], [], [1], [2], []]
 * <strong>输出: </strong>[null, true, false, true, 2, true, false, 2]
 * <strong>解释:
 * </strong>RandomizedSet randomSet = new RandomizedSet();  // 初始化一个空的集合
 * randomSet.insert(1); // 向集合中插入 1 ， 返回 true 表示 1 被成功地插入
 *
 * randomSet.remove(2); // 返回 false，表示集合中不存在 2
 *
 * randomSet.insert(2); // 向集合中插入 2 返回 true ，集合现在包含 [1,2]
 *
 * randomSet.getRandom(); // getRandom 应随机返回 1 或 2
 *
 * randomSet.remove(1); // 从集合中移除 1 返回 true 。集合现在包含 [2]
 *
 * randomSet.insert(2); // 2 已在集合中，所以返回 false
 *
 * randomSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong><meta charset="UTF-8" /></p>
 *
 * <ul>
 * <li><code>-2<sup>31</sup>&nbsp;&lt;= val &lt;= 2<sup>31</sup>&nbsp;- 1</code></li>
 * <li>最多进行<code> 2 * 10<sup>5</sup></code> 次&nbsp;<code>insert</code> ， <code>remove</code> 和 <code>getRandom</code> 方法调用</li>
 * <li>当调用&nbsp;<code>getRandom</code> 方法时，集合中至少有一个元素</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 380&nbsp;题相同：<a href="https://leetcode-cn.com/problems/insert-delete-getrandom-o1/">https://leetcode-cn.com/problems/insert-delete-getrandom-o1/</a></p>
 * <div><div>Related Topics</div><div><li>设计</li><li>数组</li><li>哈希表</li><li>数学</li><li>随机化</li></div></div><p><div><li>👍 0</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_030FortPu {
    public static void main(String[] args) {
        RandomizedSet solution = new P剑指_Offer_II_030FortPu().new RandomizedSet();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Node {
        Node pre;
        Node next;
        int val;

        public Node(Node pre, Node tail, int val) {
            this.pre = pre;
            this.next = tail;
            this.val = val;
        }

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    class RandomizedSet {
        Node head;
        Node tail;
        Map<Integer, Node> map;
        ArrayList<Node> list;

        public RandomizedSet() {
            head = new Node();
            tail = new Node();
            map = new HashMap<>();
            list = new ArrayList<>();
            head.next = tail;
            tail.pre = head;
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val))
                return false;
            Node node = new Node(val);
            tail.pre.next = node;
            node.pre = tail.pre;
            node.next = tail;
            tail.pre = node;
            list.add(node);
            map.put(val, node);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val))
                return false;
            Node node = map.get(val);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            map.remove(val);
            list.remove(node);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int index = (int) (Math.random() * list.size());
            return list.get(index).val;
        }

    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}