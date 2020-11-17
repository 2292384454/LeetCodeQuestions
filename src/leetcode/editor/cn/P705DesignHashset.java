//不使用任何内建的哈希表库设计一个哈希集合 
//
// 具体地说，你的设计应该包含以下的功能 
//
// 
// add(value)：向哈希集合中插入一个值。 
// contains(value) ：返回哈希集合中是否存在这个值。 
// remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。 
// 
//
// 
//示例: 
//
// MyHashSet hashSet = new MyHashSet();
//hashSet.add(1);         
//hashSet.add(2);         
//hashSet.contains(1);    // 返回 true
//hashSet.contains(3);    // 返回 false (未找到)
//hashSet.add(2);          
//hashSet.contains(2);    // 返回 true
//hashSet.remove(2);          
//hashSet.contains(2);    // 返回  false (已经被删除)
// 
//
// 
//注意： 
//
// 
// 所有的值都在 [0, 1000000]的范围内。 
// 操作的总数目在[1, 10000]范围内。 
// 不要使用内建的哈希集合库。 
// 
// Related Topics 设计 哈希表 
// 👍 70 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：设计哈希集合
public class P705DesignHashset {
    public static void main(String[] args) {
        MyHashSet myHashSet = new P705DesignHashset().new MyHashSet();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashSet {
        /**
         * Initialize your data structure here.
         */
        private boolean values[];

        public MyHashSet() {
            values = new boolean[1000001];
        }

        public void add(int key) {
            values[key] = true;
        }

        public void remove(int key) {
            values[key] = false;
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            return values[key];
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}