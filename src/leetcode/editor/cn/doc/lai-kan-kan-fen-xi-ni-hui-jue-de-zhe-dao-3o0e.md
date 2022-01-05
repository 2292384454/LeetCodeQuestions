## 题目：剑指 Offer 44. 数字序列中某一位的数字

数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

请写一个函数，求任意第n位对应的数字。

## 分析：

这是一道单纯的数学题，当n小于10，直接返回结果，这个大家都能想到。name当n大于10呢？

我们先将n-=9，然后规律就出来了...

```
10 11 12 ... 98 99              --> 90   个数字每个数字占两位
100 101 102 ... 998 999         --> 900  个数字每个数字占三位
1000 1001 1002 ... 9998 9999    --> 9000 个数字每个数字占四位

第一行共有 10*9*2 个数
第二行公有 10*10*9*3 个数
第三行公有 10*10*10*9*4 个数

好了规律出来了: 
假设初始标记count = 1 
每行总数字为：10**count * 9 * (count+1) 

另外关于整除后的余数：
如果没有余数，那结果就是基数（10**count） + 商 - 1，然后获取这个数的最后一个数字即可
如果有余数，那结果就是基数（10**count） + 商，获取到当前的数字，然后 余数-1 找到对应index返回即可
```
这么分析，是不是觉得这个题太easy了...

## 解题：

```python
class Solution:
    def findNthDigit(self, n: int) -> int:
        if n < 10:
            return n
        n -= 9
        count = 1
        while True:
            num = 10 ** count * 9 * (count + 1)
            if n > num:
                n -= num
                count += 1
            else:
                i, j = divmod(n, (count + 1))
                if not j:
                    return int(str(10 ** count + i - 1)[-1])
                else:
                    return int(str(10 ** count + i)[j - 1])
```

欢迎关注我的公众号: **清风Python**，带你每日学习Python算法刷题的同时，了解更多python小知识。

有喜欢力扣刷题的小伙伴可以加我微信（King_Uranus）互相鼓励，共同进步，一起玩转超级码力！

我的个人博客：[https://qingfengpython.cn](https://qingfengpython.cn)

力扣解题合集：[https://github.com/BreezePython/AlgorithmMarkdown](https://github.com/BreezePython/AlgorithmMarkdown)