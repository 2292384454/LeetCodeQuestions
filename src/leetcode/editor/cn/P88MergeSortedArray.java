//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

package leetcode.editor.cn;

import java.util.Arrays;

//Java：合并两个有序数组
public class P88MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
        // TO TEST
        int nums1[] = {1, 0};
        int nums2[] = {2};
        solution.merge(nums1, 1, nums2, 1);
        for (int x : nums1) {
            System.out.println(x);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            //牺牲空间复杂度换取时间复杂度，时间复杂度O(m+n)，空间复杂度O(m+n)
            int result[] = new int[m + n];//开辟存储空间存储结果
            //如果m=0那么将nums2[]的值都复制给nums1[]就行了
            if (m == 0)
                System.arraycopy(nums2, 0, nums1, 0, nums2.length);
                //如果 n=0那么不需要做任何处理
            else if (n == 0) ;
                // 如果m和n都不等于0，开始进行元素的重新插入
            else {
                //temp1指向首元素更小的数组，l1为其对应的要处理数据的长度
                int temp1[] = nums1[0] < nums2[0] ? nums1 : nums2;
                int l1 = nums1[0] < nums2[0] ? m : n;
                //temp2指向另一个数组，l2为其对应的要处理数据的长度
                int temp2[] = nums1[0] >= nums2[0] ? nums1 : nums2;
                int l2 = nums1[0] >= nums2[0] ? m : n;

                for (int i = 0, j = 0; i < l1 && j < l2; ) {
                    //在temp1[]的元素始终小于temp2[0]时，直接将temp1的元素复制给result[]
                    if (temp1[i] < temp2[0] && i < l1 - 1)
                        result[i + j] = temp1[i++];
                        //在temp1[]的元素开始大于等于temp2[0]时，进入比较环节
                    else {
                        //将较小的元素插入到result[]结尾
                        if (temp1[i] < temp2[j])
                            result[i + j] = temp1[i++];
                        else
                            result[i + j] = temp2[j++];
                        //如果有一个指针已经完成了所有元素的比较，就将另一个数组剩下的元素直接复制到result结尾
                        if (i >= l1) {
                            System.arraycopy(temp2, j, result, i + j, l2 - j);
                            break;
                        }
                        if (j >= l2) {
                            System.arraycopy(temp1, i, result, i + j, l1 - i);
                            break;
                        }
                    }
                }
                //将result[]的元素复制到nums1[]
                System.arraycopy(result, 0, nums1, 0, result.length);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}