package cn.bravedawn.jd.jd_121;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : fengx9
 * @Project : leetcode-main
 * @Date : Created in 2024-03-12 09:15
 */
public class Solution2 {

    /**
     * 字节面试题：计算股票的最大收益
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 2, 6, 1};
        compute(1000, nums);

        // 4000
        // 8000
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
                    num = 0;
                }
                continue;
            }

            if (i < n - 1 && prices[i] >= prices[i + 1] && prices[i] > lastMoney) {
                if (num == 0) {
                    list.add("hold");
                } else {
                    list.add("sell");
                    money += num * (prices[i] - lastMoney);
                    num = 0;
                }

            } else {
                if (num == 0) {
                    list.add("buy");
                    lastMoney = prices[i];
                    num = money / prices[i];
                    money = 0;
                } else {
                    list.add("hold");
                }
            }

        }

        System.out.println(money - initMoney);
        System.out.println(list);
    }
}
