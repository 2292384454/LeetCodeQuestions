### 解题思路
- 能否被5整除，我们就看二进制的十进制数的个位是否为**0**或**5**。
- 所以我们只需要保留个位数，即对结果%10。
![123.png](https://pic.leetcode-cn.com/1607687715-tOwDvD-123.png)


### 代码

```cpp
class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& A) {
        int temp=0;
        vector<bool> ans(A.size(),false);
        for(int i=0;i<A.size();i++){
            temp=(temp+A[i])%10;
            if(temp==0 || temp==5) ans[i]=true;
            temp*=2;
        }
        return ans;
    }
};
```