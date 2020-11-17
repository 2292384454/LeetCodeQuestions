//
// 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的
//种类数。 
//
// 示例 1: 
//
// 
//输入: candies = [1,1,2,2,3,3]
//输出: 3
//解析: 一共有三种种类的糖果，每一种都有两个。
//     最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
// 
//
// 示例 2 : 
//
// 
//输入: candies = [1,1,2,3]
//输出: 2
//解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
// 
//
// 注意: 
//
// 
// 数组的长度为[2, 10,000]，并且确定为偶数。 
// 数组中数字的大小在范围[-100,000, 100,000]内。
// 
// 
// 
// 
// Related Topics 哈希表 
// 👍 84 👎 0

package leetcode.editor.cn;

//Java：分糖果
public class P575DistributeCandies {
    public static void main(String[] args) {
        Solution solution = new P575DistributeCandies().new Solution();
        // TO TEST
        System.out.println(solution.distributeCandies(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int distributeCandies(int[] candies) {
            int len = candies.length;
            if (len == 0) return 0;
            int min = 100000, max = -100000, result = 0;//min和max分别为最小的糖果编号与最大的糖果编号
            for (int x : candies) {
                if (x < min) min = x;
                if (x > max) max = x;
            }
            short candies_count[] = new short[max - min + 1];
            for (int x : candies)
                candies_count[x - min]++;//统计每种糖果出现的次数
            //对每种糖果都先选一个，如果糖果还没选完就够了，那么返回结果即可。
            //如果选完了还没够，那么最后的结果也只能是糖果的总种类数
            for (int i = 0; i < candies_count.length; i++) {
                if (result == candies.length / 2) return result;
                if (candies_count[i] > 0) {
                    result++;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}