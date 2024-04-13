package cn.bravedawn.zd.zd_1870;

/**
 * @author : depers
 * @program : leetcode
 * @date : Created in 2024/2/18 09:43
 *
 * 1870. 准时到达的列车最小时速
 */
public class Solution {

    public static int minSpeedOnTime(int[] dist, double hour) {

        int n = dist.length;


        // 时间必须要大于路程段数减 1
        if (hour <= n - 1){
            return -1;
        }

        int left = 0;
        int right = 1000_0000 + 1;
        int result = -1;
        while (left <= right && right > 0) {
            int mid = left + (right - left) / 2;

            double time = 0;
            // 对于n-1段路程来讲
            for(int i = 0; i < n-1; i++){
                if (dist[i] % mid == 0) {
                    time += dist[i] / mid;
                } else {
                    time += dist[i] / mid + 1;
                }
            }
            // 最后一段贡献的时间： dist[n-1] / mid
            time += (double) dist[n-1] / mid;

            if (time <= hour) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;

    }





    public static void main(String[] args) {
        int[] dist = {1,3,2};
        double hour = 6;

        int[] dist2 = {1,3,2};
        double hour2 = 2.7;

        int[] dist3 = {1,3,2};
        double hour3 = 1.9;

        int[] dist4 = {1,1,100000};
        double hour4 = 2.01;

        int[] dist5 = {5,3,4,6,2,2,7};
        double hour5 = 10.92;
        int result = minSpeedOnTime(dist, hour);
        System.out.println(result);


    }

}
