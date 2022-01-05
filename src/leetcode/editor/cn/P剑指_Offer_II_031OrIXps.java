package leetcode.editor.cn;
//Java：最近最少使用缓存

import java.util.HashMap;

/**
 * <div class="title__3Vvk">
 * <p>运用所掌握的数据结构，设计和实现一个&nbsp; <a href="https://baike.baidu.com/item/LRU" target="_blank">LRU (Least Recently Used，最近最少使用) 缓存机制</a> 。</p>
 *
 * <p>实现 <code>LRUCache</code> 类：</p>
 *
 * <ul>
 * <li><code>LRUCache(int capacity)</code> 以正整数作为容量&nbsp;<code>capacity</code> 初始化 LRU 缓存</li>
 * <li><code>int get(int key)</code> 如果关键字 <code>key</code> 存在于缓存中，则返回关键字的值，否则返回 <code>-1</code> 。</li>
 * <li><code>void put(int key, int value)</code>&nbsp;如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例：</strong></p>
 *
 * <pre>
 * <strong>输入</strong>
 * [&quot;LRUCache&quot;, &quot;put&quot;, &quot;put&quot;, &quot;get&quot;, &quot;put&quot;, &quot;get&quot;, &quot;put&quot;, &quot;get&quot;, &quot;get&quot;, &quot;get&quot;]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * <strong>输出</strong>
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * <strong>解释</strong>
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= capacity &lt;= 3000</code></li>
 * <li><code>0 &lt;= key &lt;= 10000</code></li>
 * <li><code>0 &lt;= value &lt;= 10<sup>5</sup></code></li>
 * <li>最多调用 <code>2 * 10<sup>5</sup></code> 次 <code>get</code> 和 <code>put</code></li>
 * </ul>
 * </div>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶</strong>：是否可以在&nbsp;<code>O(1)</code> 时间复杂度内完成这两种操作？</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><meta charset="UTF-8" />注意：本题与主站 146&nbsp;题相同：<a href="https://leetcode-cn.com/problems/lru-cache/">https://leetcode-cn.com/problems/lru-cache/</a>&nbsp;</p>
 * <div><div>Related Topics</div><div><li>设计</li><li>哈希表</li><li>链表</li><li>双向链表</li></div></div><p><div><li>👍 1</li><li>👎 0</li></div>
 */
public class P剑指_Offer_II_031OrIXps {
    public static void main(String[] args) {
        LRUCache lru = new P剑指_Offer_II_031OrIXps().new LRUCache(2);
        // TO TEST
        lru.put(1, 1); // 缓存是 {1=1}
        lru.put(2, 2); // 缓存是 {1=1, 2=2}
        lru.get(1);    // 返回 1
        lru.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lru.get(2);    // 返回 -1 (未找到)
        lru.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lru.get(1);    // 返回 -1 (未找到)
        lru.get(3);    // 返回 3
        lru.get(4);    // 返回 4
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // class LRUCache extends LinkedHashMap<Integer, Integer> {
    //     int capacity;
    //
    //     public LRUCache(int capacity) {
    //         super(2, 0.75f, true);
    //         this.capacity = capacity;
    //     }
    //
    //     public int get(int key) {
    //         return super.getOrDefault(key, -1);
    //     }
    //
    //     public void put(int key, int value) {
    //         super.put(key, value);
    //     }
    //
    //     @Override
    //     protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
    //         return this.size() > capacity;
    //     }
    // }

    class LRUCache {
        int capacity;
        Node head, tail;
        HashMap<Integer, Node> cache;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>(capacity);
            head = new Node(-1, -1);
            tail = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                int val = node.val;
                moveToHead(node);
                return val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            Node node;
            if (cache.containsKey(key)) {
                // 如果 key 存在就修改其 value ，并将其移动到头部
                node = cache.get(key);
                node.val = value;
                moveToHead(node);
            } else {
                // 否则就在头部进行插入
                node = new Node(key, value);
                insertHead(node);
                cache.put(key, node);
                if (cache.size() > capacity) {
                    Node rem = removeTail();
                    cache.remove(rem.key);
                }
            }
        }

        private void insertHead(Node node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }

        private void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private void moveToHead(Node node) {
            remove(node);
            insertHead(node);
        }

        private Node removeTail() {
            Node node = tail.pre;
            remove(node);
            return node;
        }

        /**
         * 双向链表节点
         */
        class Node {
            int key, val;
            Node pre, next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}