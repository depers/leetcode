package cn.bravedawn.jd_121;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : fengx9
 * @Project : leetcode
 * @Date : Created in 2024-01-23 15:47
 *
 * 121. 买卖股票的最佳时机
 */
public class Solution {


    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }


    /**
     * 自己的实现
     */
    public static int maxProfit(int[] prices) {
        int money = 0;
        int length = prices.length;

        for (int i = 0; i < length; i++) {
            int getPrice = prices[i];
            int sellPrice = 0;
            for (int j = i; j < length; j++) {
                sellPrice = prices[j];
                int currentMoney = sellPrice - getPrice;
                if (currentMoney > money) {
                    money = currentMoney;
                }
            }
        }

        return money;
    }

    /**
     * 官方的实现
     */
    public static int maxProfit_2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
