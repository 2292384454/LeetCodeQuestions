//给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。 
//
// h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引
//用了至少 h 次。且其余的 N - h 篇论文每篇被引用次数 不超过 h 次。 
//
// 例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。 
//
// 
//
// 示例： 
//
// 
//输入：citations = [3,0,6,1,5]
//输出：3 
//解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
//     由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。 
//
// 
//
// 提示：如果 h 有多种可能的值，h 指数是其中最大的那个。 
// Related Topics 排序 哈希表 
// 👍 143 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：H 指数
public class P274HIndex {
    public static void main(String[] args) {
        Solution solution = new P274HIndex().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hIndex(int[] citations) {
            //我们想象一个直方图，其中 x 轴表示文章，y 轴表示每篇文章的引用次数。
            // 如果将这些文章按照引用次数降序排序并在直方图上进行表示，那么直方图上的最大的正方形的边长 h 就是我们所要求的 h。
            Arrays.sort(citations);
            // 线性扫描找出最大的 i
            int i = 0;
            //当高第一次小于等于正方形的边长时返回边长
            while (i < citations.length && citations[citations.length - 1 - i] > i) {
                i++;
            }
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
