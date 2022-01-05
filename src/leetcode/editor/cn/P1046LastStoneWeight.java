//有一堆石头，每块石头的重量都是正整数。 
//
// 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下： 
//
// 
// 如果 x == y，那么两块石头都会被完全粉碎； 
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。 
// 
//
// 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。 
//
// 
//
// 示例： 
//
// 输入：[2,7,4,1,8,1]
//输出：1
//解释：
//先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
//再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
//接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
//最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 1000 
// 
// Related Topics 堆 贪心算法 
// 👍 138 👎 0

package leetcode.editor.cn;


//Java：最后一块石头的重量
public class P1046LastStoneWeight {
    public static void main(String[] args) {
        Solution solution = new P1046LastStoneWeight().new Solution();
        // TO TEST
        int stones[] = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(solution.lastStoneWeight(stones));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastStoneWeight(int[] stones) {
            if (stones.length == 2) {
                return Math.abs(stones[1] - stones[0]);
            }
            int[] heap = new int[2], indexOfHeap = new int[2];//heap为大根堆,indexOfHeap存储heap中元素在stones的原下标
            int len = stones.length;
            while (len > 1) {
                //遍历整个数组，找到最大的两个数字，加入heap
                for (int i = 0; i < stones.length; i++) {
                    if (stones[i] > heap[0]) {
                        heap[1] = heap[0];
                        indexOfHeap[1] = indexOfHeap[0];
                        heap[0] = stones[i];
                        indexOfHeap[0] = i;
                    } else if (stones[i] > heap[1]) {
                        heap[1] = stones[i];
                        indexOfHeap[1] = i;
                    }
                }
                //如果heap中两个数字相等，那么heap中的两块石头会互相抵消掉,len-=2
                //否则的话就用他们的差替代原本较大的那个数字，至于较小的那块石头一定会消失,len--
                if (heap[0] == heap[1]) {
                    stones[indexOfHeap[0]] = 0;
                    len -= 2;
                } else {
                    stones[indexOfHeap[0]] = heap[0] - heap[1];
                    len--;
                }
                stones[indexOfHeap[1]] = 0;
                heap[0] = 0;
                heap[1] = 0;
            }
            if (len == 0) {
                return 0;
            }
            for (int x : stones) {
                if (x != 0) {
                    return x;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
