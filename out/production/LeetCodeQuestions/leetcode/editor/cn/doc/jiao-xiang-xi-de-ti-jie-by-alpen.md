### 解题思路
实现逻辑：
1.取得当前机器人的方向，开始移动
2.每移动一步前判断该位置是否为障碍物，如果存在障碍物，结束当前路径的移动
3.若无障碍物，移动，更新当前位置，然后与当前的最远距离比较，如果大于最远距离则更新最远距离。
4.移动完毕后取得最远距离

实现方法：
1.-1、-2表示左右移动，需要工具指定东南西北，判断左右移动方向从而取得当前的朝向。
2.每移动一步都需要判断障碍物，所以需要快速寻找，这里可以考虑使用hashmap或者hashset
3.每一个朝向的移动就是一个循环，只要遇到障碍物就结束当前循环，每循环一次都比较一次最远距离
4.返回最远距离

### 代码

```java
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        //direction表当前朝向，0123 表 北东南西
        int ans = 0, direction = 0, x = 0, y = 0;
        //每个朝向上的数据变化，比如朝北时取Direction[0]  ->   {0,1}
        //那么x轴的变化为x+0，y轴变化为y+1;
        int[][] Direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        HashSet<String> set = new HashSet<>();
        //将所有障碍物坐标组合成字符串存入set中方便查询
        for (int[] arr : obstacles) {
            set.add(arr[0] + "，" + arr[1]);
        }

        for (int com : commands) {
            //定义下一步的坐标
            int next_x = 0, next_y = 0;
            //当命令为前进，开始移动
            if (com >= 0) {
                for (int i = 0; i < com; i++) {
                    //取得下一步的坐标
                    next_x = x + Direction[direction][0];
                    next_y = y + Direction[direction][1];
                    //若下一步有障碍物，结束当前命令，跳至下一命令
                    if (set.contains(next_x + "，" + next_y)) {
                        break;
                    }
                    //否则更新坐标与最远距离
                    x = next_x;
                    y = next_y;
                    ans = Math.max(ans, x * x + y * y);
                }
            } else {
                //改变朝向
                direction = com == -1 ? (direction + 1) % 4 : (direction + 3) % 4;
            }
        }
        return ans;
    }
}
```