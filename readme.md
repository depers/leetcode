# leetcode

## 第一阶段刷题

* 开始时间：2024年1月24日
* LeetCode 100题：https://leetcode.cn/studyplan/top-100-liked/
* 刷题参考项目：https://github.com/doocs/leetcode
* 刷题统计

  | 难度 | 数量 |
  |----|----|
  | 简单 | 11 |
  | 中等 | 49 |
  | 困难 | 0  |

## 算法归类
### 1.动态规划
* 问题可以拆分为前一步子问题来分析，通过从低到高的逻辑求解最后的答案，具体步骤可以分为dp数组的含义分析、递推公式、初始化、遍历循序这四步进行分析。
* 是一种自底向上解决问题的一种方案
* 当前的问题可以共同上一步的结论来进行计算
### 2.回溯（深度优先遍历）
* 树型结构
* 矩阵
### 3.双指针

### 4.二分查找

### 5.链表

### 6.递归
1. 确定递归函数返回值以及参数
2. 确定终止条件
3. 确定单层递归逻辑

| 序号 | 题目 |
|----|--|
| 1  | 142.环形链表II |

## 反思
### 1.动态规划和回溯的区别
1. 问题规模：动态规划通常处理规模较大的问题，通过递推或填表的方式求解；回溯法则适用于更小规模的问题。
2. 求解方式：
   * 动态规划是自底向上的求解过程，通过保存已计算的结果来避免重复计算。
   * 回溯法是一种深度优先搜索，通过尝试不同的路径来找到解。
3. 存储空间：
   * 动态规划通常需要存储中间结果，可能需要较大的存储空间。
   * 回溯法在搜索过程中只需要存储当前状态。
4. 适用问题：
   * 动态规划适用于具有最优子结构的问题。
   * 回溯法适用于组合问题，如排列、组合等。
5. 时间复杂度：
   * 动态规划的时间复杂度通常较低。
   * 回溯法的时间复杂度可能较高。
  
## 题目清单的解法

| 序号 | 题目                       | 算法                    | 数据结构   | 难度 |
|----|--------------------------|-----------------------|--------|----|
| 1  | 94.二叉树的中序遍历（富途）          | 1.递归<br/>2.借助栈的非递归实现  | 二叉树    |    |
| 2  | 300.最长递增子序列              | 动态规划                  | 动态规划   |    |
| 3  | 5.最长回文子串                 | 1.暴力破解法<br/>2.动态规划    | 动态规划   |    |
| 4  | 1.两数之和                   | 哈希                    | 哈希     |    |
| 5  | 70.爬楼梯                   | 动态规划                  | 动态规划   |    |
| 6  | 9.回文数                    | 栈                     | 栈      |    |
| 7  | 121.买卖股票的最佳时机（字节）        | 暴力破解                  | 贪心算法   |    |
| 8  | 2.两数相加                   | 链表                    | 链表     |    |
| 9  | 3.无重复字符的最长子串             | 滑动窗口                  | 滑动窗口   |    |
| 10 | 34.在排序数组中查找元素的第一个和最后一个位置 | 二分查找                  | 二分查找   |    |
| 11 | 56.合并区间（字节）              | 暴力破解                  | 数组     |    |
| 12 | 118.杨辉三角                 |                       | 动态规划   |    |
| 13 | 215.数组中的第K个最大元素          | 快速排序                  | 堆/快速排序 |    |
| 14 | 75.颜色分类                  | 快速排序                  | 快速排序   |    |
| 15 | 283.移动零                  | 双指针                   | 双指针    |    |
| 16 | 11.盛最多水的容器               | 双指针                   | 双指针    |    |
| 17 | 20.有效的括号                 | 栈                     | 栈      |    |
| 18 | 621.任务调度器                | 找规律                   |        |    |
| 19 | 146.LRU缓存（阿里钉钉面试题）       | Java LinkedHashMap的使用 | 链表     |    |
| 20 | 15.三数之和                  | 双指针                   | 双指针    |    |
| 21 | 22.括号生成                  | 深度优先搜索                | 二叉树    |    |
| 22 | 200.岛屿数量                 | 深度优先搜索                | 图      |    |
| 23 | 49.字母异位词分组               | 遍历                    | 哈希Map  |    |
| 24 | 128.最长连续序列               |                       | 哈希Set  |    |
| 25 | 230.二叉搜索树中第K小的元素（字节）     |                       | 二叉树    |    |
| 26 | 46. 全排列                  | 回溯（深度优先遍历）            | 栈      |    |
| 27 | 438.找到字符串中所有字母异位词        | 1.滑动窗口<br/>2.字符串截取    |        |    |
| 28 | 560.和为K的子数组              |                       | 数组     |    |
| 29 | 53.最大子数组和                | 动态规划                  |        |    |
| 30 | 189.轮转数组                 |                       | 数组     |    |
| 31 | 238.除自身以外数组的乘积           | 左右乘积表                 | 数组     |    |
| 32 | 73.矩阵置零                  |                       | 矩阵     |    |
| 33 | 54.螺旋矩阵                  |                       | 矩阵     |    |
| 34 | 17.电话号码的字母组合             | 回溯（和46题类似）            |        |    |
| 35 | 19.删除链表的倒数第 N 个结点        |                       | 链表     |    |
| 36 | 31.下一个排列                 | 技巧                    | 数组     |    |
| 37 | 153.寻找旋转排序数组中的最小值        | 二分查找                  |        |    |
| 38 | 33.搜索旋转排序数组              | 二分查找                  |        |    |
| 39 | 39.组合总和                  | 回溯                    | 栈      |    |
| 40 | 48.旋转图像                  |                       | 矩阵     |    |
| 41 | 55.跳跃游戏                  | 贪心算法                  |        |    |
| 42 | 62.不同路径                  | 动态规划                  |        |    |
| 43 | 64.最小路径和                 | 动态规划                  |        |    |
| 44 | 72.编辑距离                  | 动态规划                  |        |    |
| 45 | 78.子集                    | 回溯（深度优先遍历）            | 树      |    |
| 46 | 79.单词搜索                  | 深度优先遍历或者说回溯（矩阵）       | 矩阵     |    |
| 47 | 96.不同的二叉搜索树              | 动态规划                  | 二叉搜索树  |    |
| 48 | 98.验证二叉搜索树               | 递归                    | 二叉搜索树  |    |
| 49 | 102.二叉树的层序遍历             | 二叉树的层级遍历算法            | 二叉树、队列 |    |
| 50 | 105.从前序与中序遍历序列构造二叉树      | 递归                    | 二叉树    |    |
| 51 | 114.二叉树展开为链表             | 二叉树的前序遍历              | 二叉树    |    |
| 52 | 139.单词拆分                 | 动态规划<br/>回溯法          |        |    |
| 53 | 142.环形链表II               | 快慢指针                  | 链表     | 中等 |
| 54 | 236. 二叉树的最近公共祖先          | 后序遍历                  | 二叉树    |    |
| 55 | 739.每日温度                 |                       | 单调栈    |    |
| 56 | 221.最大正方形                | 动态规划                  |        |    |
| 57 | 208.实现 Trie (前缀树)        |                       | 多叉树    |    |
| 58 | 148.链表排序                 | 1.快速排序<br/>2.归并排序     |        |    |
| 59 | 207.课程表                  | 拓扑排序                  | 有向无环图  |    |
| 60 | 198.打家劫舍                 | 动态规划                  |        |    |
| 61 | 155.最小栈                  |                       | 栈      |    |
| 62 | 152.乘积最大子数组           | 动态规划                  |        |    |








