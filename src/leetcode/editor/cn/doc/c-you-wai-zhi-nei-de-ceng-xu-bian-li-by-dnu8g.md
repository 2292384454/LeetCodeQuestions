### 解题思路
![310. 最小高度树.jpg](https://pic.leetcode-cn.com/1612864443-cUtCGE-310.%20%E6%9C%80%E5%B0%8F%E9%AB%98%E5%BA%A6%E6%A0%91.jpg)

找到数的最小高度，那么就像层序遍历一样，从最外层一层一层往里数，当剩下的元素均在同一层时，这些元素就是最小层的元素了

具体实现方式和按层分组的层序遍历类似，先把最外层入队，然后每次循环队中全部元素。
找到这个元素未遍历过的相邻元素并入队。
直至一轮开始时剩余元素数量等于队中元素数量就不再遍历，因为这些就是全部能作为答案的元素了（也就是最中间层的元素）；

很显然，如果剩余元素比队中的多，那么说明还有元素没有遍历到，需要继续遍历；
剩余元素不会比队中的少，因为入队的元素是唯一且为剩余元素的。

### 代码

```cpp
class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        vector<set<int>> vex(n);
        vector<int> mark(n, 0);
        for(auto& x: edges){//建立邻接表和度数表
            int a = x[0], b = x[1];

            vex[a].insert(b);
            vex[b].insert(a);
            mark[a]++;
            mark[b]++;
        }

        queue<int> Q;
        for(int i = 0; i < n; i++){//初始化队列
            if(mark[i] <= 1){
                Q.push(i);
            }
        }

        while(Q.size() != n){//如果剩余的点在同一层，它们即为所求点集
            int size = Q.size();
            n -= size;//本轮遍历size个点，更新剩余点数量n

            while(size--){//遍历外层的点
                int p = Q.front();
                Q.pop();

                for(auto& x: vex[p]){//把相邻点的度数-1，把新的度为1的点入队（作为下一层）
                    if(mark[x] > 1){
                        mark[x]--;
                        if(mark[x] == 1){
                            Q.push(x);
                        }                        
                    }
                }
            }
        }

        vector<int> ans;
        while(Q.size()){//把所求的点集转移至数组
            ans.push_back(Q.front());
            Q.pop();
        }

        return ans;
    }
};
```