package Solution.DynamicPlan.序列型;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/        买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/     买卖股票的最佳时机II
 * https://www.lintcode.com/problem/151                                     买卖股票的最佳时机III
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/     买卖股票的最佳时机IV
 *
 * 所有的股票买卖以及其类似问题，都只需要做出2k + 1中状态（k为可买卖次数）即可
 * 属于单向转换型的DP问题
 */
public class 买卖股票的最佳时机 {

    /**
     * 只做一笔交易
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[3][prices.length];

        for (int i = 0; i < 3; i++) {
            if (i % 2 != 0) {
                dp[i][0] = -prices[0];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < prices.length; j++) {
                switch (i) {
                    case 0:
                        dp[i][j] = 0;
                        break;

                    case 1:
                        dp[i][j] = Math.max(-prices[j], dp[i][j - 1]);
                        break;

                    case 2:
                        dp[i][j] = Math.max(prices[j] + dp[i - 1][j - 1], dp[i][j - 1]);
                        break;
                }
            }
        }

        return Math.max(0, dp[2][prices.length - 1]);
    }

    /**
     * 可以做无数笔交易
     * 只需要把所有上升沿买下即可
     */
    public int maxProfitII(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                ans += (prices[i] - prices[i - 1]);
        }
        return ans;
    }

    /**
     * 最多两笔交易
     */
    public int maxProfitIII(int[] prices) {
        // write your code here
        if(prices.length == 0) return 0;
        int k = 2 * 2 + 1;
        int[][] dp = new int[prices.length][k];

        for (int i = 0; i < k; i++) {
            if (i % 2 != 0)
                dp[0][i] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < k; j++) {
                if (j % 2 != 0) {
                    //持有态
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    //空仓态
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }

        return dp[prices.length - 1][k - 1];
    }

    public int maxProfitIV(int K, int[] prices) {
        if(prices.length == 0) return 0;
        if(K > prices.length * 2) {
            int ans = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1])
                    ans += (prices[i] - prices[i - 1]);
            }
            return ans;
        }
        int k = K * 2 + 1;
        int[][] dp = new int[prices.length][k];

        for (int i = 0; i < k; i++) {
            if (i % 2 != 0)
                dp[0][i] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < k; j++) {
                if (j % 2 != 0) {
                    //持有态
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    //空仓态
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }

        return dp[prices.length - 1][k - 1];
    }

    @Test
    public void test() {
        int[] arr = {1, 2};
        maxProfit(arr);
    }

    @Test
    public void test3() {
        int[] arr = {1, 2};
        maxProfitIII(arr);
    }
}