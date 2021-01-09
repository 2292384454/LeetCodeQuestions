### 解题思路
因为遍历矩阵是避免不了的，因此从头遍历矩阵，并计算距离同时将点坐标和距离保存到Map中，然后遍历输出结果即可。（应用的是Map针对key为Integer话会默认排序）
时间73.79
空间96.06

### 代码

```java
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		Map<Integer,List<int[]>> map = new HashMap<>();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				int dist = Math.abs(i-r0)+Math.abs(j-c0);
				List<int[]> list = map.getOrDefault(dist, new ArrayList<int[]>());
				list.add(new int[] {i,j});
				map.put(dist, list);
			}
		}
		int k = 0;
		int[][] res = new int[R*C][];
		for(Integer i : map.keySet()) {
			for(int[] t : map.get(i)) {
				res[k++] = t;
			}
		}
		return res;
    }
}
```