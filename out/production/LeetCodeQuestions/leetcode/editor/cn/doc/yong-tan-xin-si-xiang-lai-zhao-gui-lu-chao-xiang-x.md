# 一、题目解读
&nbsp;&nbsp;&nbsp;&nbsp;题目中给出了pos[i]位置上的筹码的两种移动方式：
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;方式一：将position[i]往前移动两格到position[i] - 2，或向后移动两格移动到position[i] + 2，移动开销为0
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;方式二：将position[i]往前移动一格到position[i] - 1，或向后移动一格移动到position[i] + 1，移动开销为1
&nbsp;&nbsp;&nbsp;&nbsp;题目的最终目标是花费最少的开销来将所有筹码移动到同一位置（注意：这个最终位置可以是数轴上的任意一个位置）
<br>
# 二、贪心策略
&nbsp;&nbsp;&nbsp;&nbsp;为了保证总开销值最小，对于每一次的移动选择，我们如果能选择开销为0的移动方式（方式一），就绝对不选择开销为1的移动方式（方式二）。因此我们尽量通过方式一先将尽量多的筹码移动到一起，在剩下的筹码无法再通过方式一来移动到同一位置的时候，尽量使用最少次数的方式二来移动。
&nbsp;&nbsp;&nbsp;&nbsp;例如：对于样例[1，2，3]，先利用方式一，将position[1]和[3] (为了方便，这里的下标从1开始)都移动到position(1)
![image.png](https://pic.leetcode-cn.com/1604896370-rpZRBQ-image.png)
&nbsp;&nbsp;&nbsp;&nbsp;现在剩下的两堆筹码无法再通过方式一来移动到一块，因此只能够使用方式二来移动。这样的移动选择有两种：一种是使用两次方式二将position[1]上的两个筹码来移动到position[2]，另一种是使用一次方式二来将position[2]上的筹码移动到position[1]，显然为了尽量减少开销，我们采用第二种移动方式，也就是用了最少次数的方式二的移动方式。
![image.png](https://pic.leetcode-cn.com/1604896597-uboCUM-image.png)
<br>
# 三、由贪心策略得出规律
&nbsp;&nbsp;&nbsp;&nbsp;由第二点的贪心策略可以得知，我们要尽量先使用方式一来移动，那么方式一最多能移动多少个筹码到同一个位置上呢？答案是能够将所有奇数位置的筹码移动到同一个位置（记作位置A），同时能够将所有偶数位置的移动到同一位置（记作位置B），并且位置A和位置B可以是数轴上任意两个相邻的位置（也就是|A-B|=1，之所以要相邻，是因为相邻的位置移动的次数最少。为了方便，我们这里统一将奇数位置的筹码移动到position[1]，将偶数位置的筹码移动到Postion[2]）.<br>
&nbsp;&nbsp;&nbsp;&nbsp;例如给定position=[1,2,3,4,5,6,7,8,9]，我们必然可以通过方式一将其中所有奇数位置的筹码（1,3,5,7,9)移动到位置position[1]，同时能够将其中所有偶数位置的筹码(2,4,6,8)移动到位置position[2]，这时候position[1]上共有5个筹码，position[2]上共有4个筹码，其他位置均无筹码。然后利用方式二将postion[2]上的4个筹码全部移动到position[1]上，总开销就为4.<br>
&nbsp;&nbsp;&nbsp;&nbsp;通过上面的描述我们总结规律发现：所有奇数位置的筹码都可以通过N次方式一移动到位置postion[1]，所有偶数位置的筹码都可以通过M次方式一移动到位置position[2].这里一共花费开销为0，然后使用K次方式二将postion[1]和postion[2]两者中筹码数量较少的那一堆移动到另一堆即可，K即为min(position[1], position[2])。而postion[1]和postion[2]中的筹码数量实际上就是position数组中奇数位置的筹码数量和偶数位置的筹码数量。<br>
&nbsp;&nbsp;&nbsp;&nbsp;因此，我们得出最终的算法：
&nbsp;&nbsp;&nbsp;&nbsp;（1）统计postion数组中奇数位置的筹码数量odd和偶数位置的筹码数量even （说明：这些筹码都可以用方式一移动到position[1]和position[2]）
&nbsp;&nbsp;&nbsp;&nbsp;（2）odd和even的较小者就是答案（说明：可以用min(odd, even)次方式二将剩余的筹码移动到同一个位置，这时候总开销就是min(odd, even)）
<br>
# 四、证明 （为了通俗易懂，这里采用简白的话语来代替严格的数学表达）
（一）证明所有偶数位置的筹码都可以通过方式一移动到postion[2]位置
&nbsp;&nbsp;&nbsp;&nbsp;对于任意一个偶数位置postion[P], 有P=2*k （k为整数），方式一每次移动2格，因此从偶数位置P移动到postion[2]共需要（2*k-2）/ 2 = (k - 1)步，k为整数，则k-1也是整数，因此说明p能通过k-1次方式一移动到Postion[2]

（二）证明所有奇数位置的筹码都可以通过方式一移动到postion[1]位置
&nbsp;&nbsp;&nbsp;&nbsp;对于任意一个奇数位置postion[P], 有P=2*k-1 （k为整数），方式一每次移动2格，因此从偶数位置P移动到postion[1]共需要（2*k-1-1）/ 2 = (k - 1)步，k为整数，则k-1也是整数，因此说明p能通过k-1次方式一移动到Postion[1]<br>
<br>
# 五、代码
```java []
class Solution {
    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int num : position) {
            if ((num & 1) == 0) even++;
            else odd++;
        }
        return Math.min(odd, even);
    }
}
```