package cn.bravedawn.jd_70;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/6 15:21
 *
 * 70. 爬楼梯
 */
public class Solution {

    /**
     * n=4时，res=5
     * n=3时，res=3
     * n=2时，res=2
     * n=1时，res=1
     *
     * f(n)=f(x-2)+f(n-1)
     */


    public int climbStairs(int n) {
        int a = 0, b = 0, res = 1;

        for (int i = 1; i <= n; i++) {
            a = b;
            b = res;
            res = a + b;
        }

        return res;
    }

}
