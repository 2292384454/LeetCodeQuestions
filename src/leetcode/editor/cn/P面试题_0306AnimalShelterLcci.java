package leetcode.editor.cn;
//Java：动物收容所

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>动物收容所。有家动物收容所只收容狗与猫，且严格遵守&ldquo;先进先出&rdquo;的原则。在收养该收容所的动物时，收养人只能收养所有动物中&ldquo;最老&rdquo;（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中&ldquo;最老&rdquo;的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如<code>enqueue</code>、<code>dequeueAny</code>、<code>dequeueDog</code>和<code>dequeueCat</code>。允许使用Java内置的LinkedList数据结构。</p>
 *
 * <p><code>enqueue</code>方法有一个<code>animal</code>参数，<code>animal[0]</code>代表动物编号，<code>animal[1]</code>代表动物种类，其中 0 代表猫，1 代表狗。</p>
 *
 * <p><code>dequeue*</code>方法返回一个列表<code>[动物编号, 动物种类]</code>，若没有可以收养的动物，则返回<code>[-1,-1]</code>。</p>
 *
 * <p><strong>示例1:</strong></p>
 *
 * <pre><strong> 输入</strong>：
 * [&quot;AnimalShelf&quot;, &quot;enqueue&quot;, &quot;enqueue&quot;, &quot;dequeueCat&quot;, &quot;dequeueDog&quot;, &quot;dequeueAny&quot;]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 * <strong> 输出</strong>：
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 * </pre>
 *
 * <p><strong>示例2:</strong></p>
 *
 * <pre><strong> 输入</strong>：
 * [&quot;AnimalShelf&quot;, &quot;enqueue&quot;, &quot;enqueue&quot;, &quot;enqueue&quot;, &quot;dequeueDog&quot;, &quot;dequeueCat&quot;, &quot;dequeueAny&quot;]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 * <strong> 输出</strong>：
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 * </pre>
 *
 * <p><strong>说明:</strong></p>
 *
 * <ol>
 * <li>收纳所的最大容量为20000</li>
 * </ol>
 * <div><div>Related Topics</div><div><li>设计</li><li>队列</li></div></div><p><div><li>👍 24</li><li>👎 0</li></div>
 */
public class P面试题_0306AnimalShelterLcci {
    public static void main(String[] args) {
        AnimalShelf animalShelf = new P面试题_0306AnimalShelterLcci().new AnimalShelf();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class AnimalShelf {
        int count = 0;
        Queue<int[]> catQueue;
        Queue<int[]> dogQueue;

        public AnimalShelf() {
            catQueue = new LinkedList<>();
            dogQueue = new LinkedList<>();
        }

        public void enqueue(int[] animal) {
            if (animal[1] == 0) {
                catQueue.add(new int[]{animal[0], animal[1], count++});
            } else {
                dogQueue.add(new int[]{animal[0], animal[1], count++});
            }
        }

        public int[] dequeueAny() {
            int[] cat = catQueue.peek();
            int[] dog = dogQueue.peek();
            if (cat != null && (dog == null || cat[2] < dog[2])) {
                catQueue.poll();
                return new int[]{cat[0], cat[1]};
            } else if (dog != null) {
                dogQueue.poll();
                return new int[]{dog[0], dog[1]};
            } else {
                return new int[]{-1, -1};
            }
        }

        public int[] dequeueDog() {
            if (dogQueue.isEmpty()) {
                return new int[]{-1, -1};
            }
            int[] dog = dogQueue.poll();
            return new int[]{dog[0], dog[1]};
        }

        public int[] dequeueCat() {
            if (catQueue.isEmpty()) {
                return new int[]{-1, -1};
            }
            int[] cat = catQueue.poll();
            return new int[]{cat[0], cat[1]};
        }
    }

/**
 * Your AnimalShelf object will be instantiated and called as such:
 * AnimalShelf obj = new AnimalShelf();
 * obj.enqueue(animal);
 * int[] param_2 = obj.dequeueAny();
 * int[] param_3 = obj.dequeueDog();
 * int[] param_4 = obj.dequeueCat();
 */
//leetcode submit region end(Prohibit modification and deletion)

}