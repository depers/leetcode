package cn.bravedawn.zd.zd_399;

import java.util.List;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/7/25 20:43
 *
 * 399.除法求值
 */
public class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationSize = equations.size();

    }

    private class UnionFind{
        // 父节点的id数组
        private int[] parent;
        // 指向父节点的权重
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
                weight[i] = 1.0;
            }
        }
    }
}
