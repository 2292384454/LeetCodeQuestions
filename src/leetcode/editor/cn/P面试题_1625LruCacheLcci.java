package leetcode.editor.cn;
//Java：LRU 缓存

import java.util.HashMap;
import java.util.Map;

/**
 * <p>设计和构建一个&ldquo;最近最少使用&rdquo;缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。</p>
 *
 * <p>它应该支持以下操作： 获取数据 <code>get</code> 和 写入数据 <code>put</code> 。</p>
 *
 * <p>获取数据 <code>get(key)</code> - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。<br>
 * 写入数据 <code>put(key, value)</code> - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre>LRUCache cache = new LRUCache( 2 // 缓存容量 );
 *
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * </pre>
 * <div><div>Related Topics</div><div><li>设计</li><li>哈希表</li><li>链表</li><li>双向链表</li></div></div><p><div><li>👍 102</li><li>👎 0</li></div>
 */
public class P面试题_1625LruCacheLcci {
    public static void main(String[] args) {
        // TO TEST
        LRUCache cache = new P面试题_1625LruCacheLcci().new LRUCache(2);
        System.out.println(cache.get(2)); // 返回 -1
        cache.put(2, 6);
        System.out.println(cache.get(1)); // 返回 -1
        cache.put(1, 5);
        cache.put(1, 2); // 该操作会使得密钥 2 作废
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class LRUCache {

        private int capacity;
        private Map<Integer, ListNode> map; //key->node
        private ListNode head;  // dummy head
        private ListNode tail;  // dummy tail

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new ListNode(-1, -1);
            tail = new ListNode(-1, -1);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            ListNode node = map.get(key);
            // 先删除该节点，再接到尾部
            node.pre.next = node.next;
            node.next.pre = node.pre;
            moveToTail(node);

            return node.val;
        }

        public void put(int key, int value) {
            // 直接调用这边的get方法，如果存在，它会在get内部被移动到尾巴，不用再移动一遍,直接修改值即可
            if (get(key) != -1) {
                map.get(key).val = value;
                return;
            }
            // 若不存在，new一个出来,如果超出容量，把头去掉
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            moveToTail(node);
            if (map.size() > capacity) {
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.pre = head;
            }
        }

        // 把节点移动到尾巴
        private void moveToTail(ListNode node) {
            node.pre = tail.pre;
            tail.pre = node;
            node.pre.next = node;
            node.next = tail;
        }

        // 定义双向链表节点
        private class ListNode {
            int key;
            int val;
            ListNode pre;
            ListNode next;

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
                pre = null;
                next = null;
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