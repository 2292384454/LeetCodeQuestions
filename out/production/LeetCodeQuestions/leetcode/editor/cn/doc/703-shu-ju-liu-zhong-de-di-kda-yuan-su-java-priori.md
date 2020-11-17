### 解题思路
- 返回当前数据流中第K大的元素,K是不变的。
- add() 作为返回最大元素的方法。
- PriorityQueue中保存k个大的元素，PriorityQueue中队首元素就是第k个元素

代码
1. KthLargest 创建一个最小堆，写入k个大的元素
2. add 保持PriorityQueue中k个元素，并返回为k的队首元素

### 代码
```java
import java.util.*;
class KthLargest {
    private PriorityQueue<Integer> PriorityQueue;
    private int fixed_k;

    // KthLargest 创建一个最小堆，写入k个大的元素
    public KthLargest(int k, int[] nums) {
        fixed_k = k;
        PriorityQueue = new PriorityQueue<>(k);
        for (int val : nums) add(val);
    }

    public int add(int val) {
        // size小于k，直接放入
        if (PriorityQueue.size() < fixed_k) {
            PriorityQueue.add(val);
        } else if (val > PriorityQueue.peek()) {
            // val大于队首元素，则删除队首 添加val
            PriorityQueue.poll();
            PriorityQueue.add(val);
        }
        // PriorityQueue中保存k个大的元素，PriorityQueue中队首元素就是第k个元素
        return PriorityQueue.peek();
    }

}

// 
class Solution {
    public static void main(String[] args){
        int k = 3;
        int[] arr = {4,5,8,2};   
        KthLargest KthLargest = new KthLargest(k, arr);
        System.out.println(KthLargest.add(3));
        System.out.println(KthLargest.add(5));
        System.out.println(KthLargest.add(10));
        System.out.println(KthLargest.add(9));
        System.out.println(KthLargest.add(4));
    }
}


```