
代码可能写的不太优雅，各位见谅~

执行结果：
通过
执行用时 :
9 ms, 在所有 Java 提交中击败了87.96%的用户
内存消耗 :
42.4 MB, 在所有 Java 提交中击败了20.00%的用户
```java
    public int findRadius(int[] houses, int[] heaters) {
        // 先排序，踩坑了，以为是顺序的。
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res= 0;
        int right = 0;
        for(int i = 0; i < houses.length; i++){
            // 找到恰好比当前房屋大的加热器
            while(right+1<heaters.length&&heaters[right]<houses[i]){
                right++;
            }
            // 特判， 否则会出现越界
            if(right==0){
                res = Math.max(res,Math.abs(heaters[right] - houses[i]));
            }else{
                res = Math.max(res,Math.min(Math.abs(heaters[right] - houses[i]),Math.abs(houses[i] - heaters[right-1])))
            }
        }
        return res;
    }
```
时间复杂度 O(nlog(n)+mlog(m)+m+n)
其中，n为hourse[]中的元素个数。 m为heaters[]中的元素个数。
