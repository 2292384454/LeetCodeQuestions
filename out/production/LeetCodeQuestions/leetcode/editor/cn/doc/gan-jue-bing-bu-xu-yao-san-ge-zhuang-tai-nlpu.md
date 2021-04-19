这个不是和买股票II一样的吗？只不过dp[i][1]要由dp[i-2][0]转移过来
```
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        vector<vector<int>>dp(n,vector<int>(2));
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<n;i++)
        {
            dp[i][0]=max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=max(dp[i-1][1],(i>1?dp[i-2][0]:0)-prices[i]);
        }
        return dp[n-1][0];
    }
};
```
