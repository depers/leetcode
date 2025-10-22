package cn.bravedawn.zd.zd_207;

import java.util.*;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/6/2 13:20
 *
 * @apiNote 207.课程表
 * @see <a href="https://www.bilibili.com/video/BV1Da41137io/?vd_source=9a9443ad05b4d05785ed56802e0553e9">leetcode 207.课程表 #拓扑排序</a>
 */
public class Solution {


    public static void main(String[] args) {
        int[][] prerequisites = {{1,0}};
        int numCourses = 2;
        System.out.println(canFinish(numCourses, prerequisites));
    }
    /**
     * 解决一件事情必须在另一件事情执行做，从而得到做事的顺序
     * @param numCourses 表示必须选修的课程数量
     * @param prerequisites prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 每门课程的前置课程数量，只有前置课程为0才能学习这门课
        int[] preCount = new int[numCourses];
        // 每门课程的后置课程，比如 [a:[b,c]]
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // 将可以学习的课程入栈
        Deque<Integer> queue = new LinkedList<>();
        // 已经学习的课程数量
        int learnedCourses = 0;

        // 填充上面两个属性
        for (int[] prerequisite : prerequisites) {
            // 将当前课程的前置课程数量+1
            preCount[prerequisite[0]] =  preCount[prerequisite[0]] + 1;
            // 获取前置课程的后置课程列表
            List<Integer> list = graph.get(prerequisite[1]);
            if (list == null) {
                list = new ArrayList<>();
                list.add(prerequisite[0]);
            } else {
                list.add(prerequisite[0]);
            }
            graph.put(prerequisite[1], list);
        }

        // 初始化，判断那些课程是可以学的
        for (int i = 0; i < numCourses; i++) {
            if (preCount[i] == 0) {
                // 说明这门课，可以直接学
                queue.push(i);
            }
        }

        while (queue.size() > 0) {
            // 说明有课程可以学
            int course = queue.pop();
            learnedCourses++;
            // 获取这门课的后置课程
            List<Integer> list = graph.get(course);
            // 将后置课程的前置课程数量扣减
            if (list != null) {
                for (Integer i : list) {
                    preCount[i]--;
                    // 如果当前课程的前置课程数量为0，说明可以学
                    if (preCount[i] == 0) {
                        queue.push(i);
                    }
                }
            }
        }

        return learnedCourses == numCourses;
    }
}
