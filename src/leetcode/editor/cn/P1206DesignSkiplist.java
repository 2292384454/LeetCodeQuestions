package leetcode.editor.cn;
//Java：设计跳表

/**
 * <p>不使用任何库函数，设计一个跳表。</p>
 *
 * <p>跳表是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。</p>
 *
 * <p>例如，一个跳表包含 [30, 40, 50, 60, 70, 90]，然后增加 80、45 到跳表中，以下图的方式操作：</p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2019/09/27/1506_skiplist.gif" style="width: 500px;"><br>
 * <small>Artyom Kalinin [CC BY-SA 3.0], via <a href="https://commons.wikimedia.org/wiki/File:Skip_list_add_element-en.gif" target="_blank" title="Artyom Kalinin [CC BY-SA 3.0 (https://creativecommons.org/licenses/by-sa/3.0)], via Wikimedia Commons">Wikimedia Commons</a></small></p>
 *
 * <p>跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)。</p>
 *
 * <p>在本题中，你的设计应该要包含这些函数：</p>
 *
 * <ul>
 * <li><code>bool search(int target)</code> : 返回target是否存在于跳表中。</li>
 * <li><code>void add(int num)</code>:&nbsp;插入一个元素到跳表。</li>
 * <li><code>bool erase(int num)</code>: 在跳表中删除一个值，如果&nbsp;<code>num</code>&nbsp;不存在，直接返回false. 如果存在多个&nbsp;<code>num</code>&nbsp;，删除其中任意一个即可。</li>
 * </ul>
 *
 * <p>了解更多 :&nbsp;<a href="https://en.wikipedia.org/wiki/Skip_list" target="_blank">https://en.wikipedia.org/wiki/Skip_list</a></p>
 *
 * <p>注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。</p>
 *
 * <p><strong>样例:</strong></p>
 *
 * <pre>Skiplist skiplist = new Skiplist();
 *
 * skiplist.add(1);
 * skiplist.add(2);
 * skiplist.add(3);
 * skiplist.search(0);   // 返回 false
 * skiplist.add(4);
 * skiplist.search(1);   // 返回 true
 * skiplist.erase(0);    // 返回 false，0 不在跳表中
 * skiplist.erase(1);    // 返回 true
 * skiplist.search(1);   // 返回 false，1 已被擦除
 * </pre>
 *
 * <p><strong>约束条件:</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= num, target&nbsp;&lt;= 20000</code></li>
 * <li>最多调用&nbsp;<code>50000</code>&nbsp;次&nbsp;<code>search</code>, <code>add</code>, 以及&nbsp;<code>erase</code>操作。</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>设计</li><li>链表</li></div></div><p><div><li>👍 75</li><li>👎 0</li></div>
 */
public class P1206DesignSkiplist {
    public static void main(String[] args) {
        Skiplist skiplist = new P1206DesignSkiplist().new Skiplist();
        // TO TEST
        skiplist.add(22);
        skiplist.add(19);
        skiplist.add(7);
        skiplist.add(3);
        skiplist.add(37);
        skiplist.add(11);
        skiplist.add(26);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Skiplist {
        /**
         * 默认随机层数概率.
         */
        private final double DEFAULT_PROBABILITY = 0.25;
        /**
         * 默认最大层数
         */
        private final int DEFAULT_MAX_LEVEL = 32;
        /**
         * 头节点
         */
        Node head = new Node(null, DEFAULT_MAX_LEVEL);
        /**
         * 表示当前nodes的实际层数，它从1开始
         */
        int currentLevel = 1;

        private double probability = DEFAULT_PROBABILITY;
        private int maxLevel = DEFAULT_MAX_LEVEL;

        public Skiplist() {
        }

        public Skiplist(double probability, int maxLevel) {
            this.probability = probability;
            this.maxLevel = maxLevel;
        }

        /**
         * 返回target是否存在于跳表中.
         */
        public boolean search(int target) {
            Node searchNode = head;
            for (int i = currentLevel - 1; i >= 0; i--) {
                searchNode = findClosest(searchNode, i, target);
                if (searchNode.next[i] != null && searchNode.next[i].value == target) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 插入一个元素到跳表.
         */
        public void add(int num) {
            int level = randomLevel();
            Node updateNode = head;
            Node newNode = new Node(num, level);
            // 计算出当前num 索引的实际层数，从该层开始添加索引
            for (int i = currentLevel - 1; i >= 0; i--) {
                //找到本层离 num 最近的 list
                updateNode = findClosest(updateNode, i, num);
                if (i < level) {
                    if (updateNode.next[i] == null) {
                        updateNode.next[i] = newNode;
                    } else {
                        Node temp = updateNode.next[i];
                        updateNode.next[i] = newNode;
                        newNode.next[i] = temp;
                    }
                }
            }
            //如果随机出来的层数比当前的层数还大，那么超过 currentLevel 的 head 直接指向 newNode
            if (level > currentLevel) {
                for (int i = currentLevel; i < level; i++) {
                    head.next[i] = newNode;
                }
                currentLevel = level;
            }

        }

        /**
         * 在跳表中删除一个值，如果 num 不存在，直接返回 false. 如果存在多个 num ，删除其中任意一个.
         */
        public boolean erase(int num) {
            boolean flag = false;
            Node searchNode = head;
            for (int i = currentLevel - 1; i >= 0; i--) {
                searchNode = findClosest(searchNode, i, num);
                if (searchNode.next[i] != null && searchNode.next[i].value == num) {
                    //找到该层中该节点
                    searchNode.next[i] = searchNode.next[i].next[i];
                    flag = true;
                }
            }
            return flag;
        }

        /**
         * 找到 level 层 value 刚好不小于 node 的节点的前一个节点
         *
         * @param node       从哪个节点开始找
         * @param levelIndex 所在层
         * @param value      要插入的节点值
         * @return level 层 value 刚好不小于 node 的节点的前一个节点
         */
        private Node findClosest(Node node, int levelIndex, int value) {
            while ((node.next[levelIndex]) != null && value > node.next[levelIndex].value) {
                node = node.next[levelIndex];
            }
            return node;
        }

        /**
         * 随机初始化层数，为1、2、3、……的概率分别为3/4、3/16、3/64、……最大为 PROBABILILTY，即 32 .
         *
         * @return 随机层数
         */
        private int randomLevel() {
            int level = 1;
            while (Math.random() < probability && level < maxLevel) {
                level++;
            }
            return level;
        }

        /**
         * 跳表节点
         */
        class Node {
            /**
             * 节点值
             */
            Integer value;
            /**
             * 节点在不同层的下一个节点
             */
            Node[] next;

            public Node(Integer value, int size) {
                this.value = value;
                this.next = new Node[size];
            }
        }
    }

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
//leetcode submit region end(Prohibit modification and deletion)

}