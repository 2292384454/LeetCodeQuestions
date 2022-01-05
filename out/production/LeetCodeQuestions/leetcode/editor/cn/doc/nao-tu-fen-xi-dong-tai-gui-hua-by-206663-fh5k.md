分析：
    能使解码方式增多的唯一途径是某字符既能独立解码又能结合解码情况的存在
    即"11"~"26"的第二个字符
初始化：
    dp[i]表示0~i子串的解码总数
    若第一个字符为'0'，则直接返回0 ， 否则dp[0] = 1;
![1X_HVPG40FJDBG9OTLHZS7V.png](https://pic.leetcode-cn.com/1616725084-rlVpaS-1X_HVPG40FJDBG9OTLHZS7V.png)
    dp[i-1]表示当前字符单独解码的解数
    dp[i-2]表示当前字符与前一位结合解码的解数
```
class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0)=='0') return 0;
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i=1;i<n;i++) {
            if (s.charAt(i)=='0') {
                if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2'){
                    if (i==1) dp[i] = 1;
                    else dp[i] = dp[i-2];
                }
                else
                    return 0;
            }
            else {
                int value = 10*(s.charAt(i-1)-'0') + (s.charAt(i)-'0');
                if (value>=11 && value<=26) {
                    if (i==1) dp[i] = dp[0] + 1;
                    else dp[i] = dp[i-1] + dp[i-2];
                }
                else dp[i] = dp[i-1];
            }
        }
        return dp[n-1];
    }
}
```


