### 解题思路
此处撰写解题思路
1. 遍历每一个房屋，为其找到离它最近的供暖器，返回它们的距离
2. 求所有最近距离的最大值
### 代码

```java
class Solution {
    public int findNearest(int n, int[] heaters){//找到离n最近的供暖器
        int ans = 1500000000;
        for(int i = 0; i < heaters.length; i++){
            ans = Math.min(ans, Math.abs(heaters[i] - n));
        }
        return ans;
    }
    public int findRadius(int[] houses, int[] heaters) {
        int rad = -1;
        for(int i = 0; i < houses.length; i++){
            //供暖器取离得最近的那个的半径
            //最小加热半径要取所有半径中最大的
            rad = Math.max(rad, findNearest(houses[i], heaters));
        }
        return rad;
    }
}
```