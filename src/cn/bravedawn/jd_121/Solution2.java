package cn.bravedawn.jd_121;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/3/11 20:21
 */
public class Solution2 {

    /**
     * 字节面试题：计算股票的最大收益
     */

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,2,6,1};
        compute(1000, nums);
    }



    public static void compute(int money, int[] prices) {
        // 持有的股票数量
        int num = 0;

        // 初始金额
        int initMoney = money;

        // 上次买入的价格
        int lastMoney = 0;

        List<String> list = new ArrayList<>();
        int n = prices.length;

        for (int i = 0; i < n; i++) {

            if (i == n - 1) {
                if (num == 0) {
                    list.add("hold");
                } else {
                    list.add("sell");
                    money += num * (prices[i] - lastMoney);
                }
            } else {
                if(num == 0) {
                    list.add("buy");
                    num = money / prices[i];
                    lastMoney = prices[i];
                    continue;
                }

                if (prices[i] <= prices[i+1] && i < n - 1) {
                    list.add("hold");
                } else {
                    list.add("sell");
                    money += num * (prices[i] - lastMoney);
                    num = 0;
                }
            }



        }

        System.out.println(money - initMoney);
        System.out.println(list);
    }
}
