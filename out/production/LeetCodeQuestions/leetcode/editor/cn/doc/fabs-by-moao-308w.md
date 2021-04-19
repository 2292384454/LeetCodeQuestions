### 解题思路
倍增

### 代码

```cpp
class Solution {
public:
    int divide(int dividend, int divisor) {
        long long ans=0,a=fabs(dividend),b=fabs(divisor);        
        while(a>=b){
            long long cnt=1,base=b;
            while(a>(base<<1))cnt<<=1,base<<=1;        
            ans+=cnt,a-=base;
        }
        ans=((dividend<0)^(divisor<0))?-ans:ans;
        return(int)((INT_MAX<ans||ans <INT_MIN)?INT_MAX:ans);
    }
};
```