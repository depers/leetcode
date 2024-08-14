package cn.bravedawn.zd.zd_399;

import java.util.*;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/7/25 20:43
 *
 * 399.除法求值
 */
public class Solution {

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a","b"));
        equations.add(Arrays.asList("b","c"));

        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a","c"));
        queries.add(Arrays.asList("b","a"));
        queries.add(Arrays.asList("a","e"));
        queries.add(Arrays.asList("a","a"));
        queries.add(Arrays.asList("x","x"));

        Solution solution = new Solution();
        double[] result = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(result));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationSize = equations.size();

        // 如果有两组比值{[a, b], [c, d]}这种，四个变量之间没有连通性，那么并查集的大小就只能是4，所以这里并查集的大小是2倍的等式列表的大小
        UnionFind unionFind = new UnionFind(equationSize * 2);

        // 第一步：将变量的值映射为id，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> map = new HashMap<>(equationSize * 2);
        int id = 0;
        for (int i = 0; i < equationSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!map.containsKey(var1)) {
                map.put(var1, id);
                id++;
            }

            if (!map.containsKey(var2)) {
                map.put(var2, id);
                id++;
            }

            unionFind.union(map.get(var1), map.get(var2), values[i]);
        }

        // 第二步：做查询
        int querySize = queries.size();
        double[] result = new double[querySize];
        for (int i = 0; i < querySize; i++) {
            List<String> query = queries.get(i);
            String var1 = query.get(0);
            String var2 = query.get(1);

            Integer id1 = map.get(var1);
            Integer id2 = map.get(var2);

            if (id1 == null || id2 == null) {
                result[i] = -1d;
            } else {
                result[i] = unionFind.isConnected(id1, id2);
            }
        }

        return result;
    }

    private class UnionFind{
        // 每一个节点的父节点的id数组
        private int[] parent;
        // 节点指向父节点的权重
        private double[] weight;

        /**
         * 构造函数
         * @param n 并查集的元素个数
         */
        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        /**
         * 合并
         * @param x x节点的id
         * @param y y节点的id
         * @param value x和y节点之间有向边的权值
         */
        public void union(int x, int y, double value) {
            // 寻找x的父节点，得到的是父节点的id
            int rootX = find(x);

            // 寻找y的父节点，得到的是父节点的id
            int rootY = find(y);

            // 如果两个节点的父节点是同一个节点，说明不需要合并，在同一个连通分量当中
            if (rootX == rootY) {
                return;
            }

            // 将x的父节点指向y的父节点
            parent[rootX] = rootY;

            // 更新节点rootX到rootY的权值
            weight[rootX] = weight[y] * value / weight[x];
        }


        /**
         * 查找（路径压缩）
         * @param x 节点x
         * @return 返回的是根节点的id（路径压缩之后节点x指向的根节点的id）
         */
        public int find(int x) {
            // 如果x节点的父节点不是自己
            if (x != parent[x]) {
                // 保存上一个节点的id
                int origin = parent[x];
                // 使用递归栈
                parent[x] = find(parent[x]);
                /// 路径压缩
                weight[x] = weight[origin] * weight[x];
            }

            return parent[x];
        }


        /**
         * 两个节点是否连接
         * @param x x节点的id
         * @param y y节点的id
         * @return 返回两个节点权重的比值
         */
        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            // 两个节点指向同一个根节点
            if (rootX == rootY) {
                return weight[x] / weight[y];
            }  else {
                // 两个节点没有连通性
                return -1d;
            }
        }
    }
}
