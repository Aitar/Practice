package Solution.DynamicPlan.划分型;

/**
 * 给出一个数字，求出平方和为此数字的最少数字数量
 * https://leetcode-cn.com/problems/perfect-squares/
 */
public class 完全平方 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 1; i / j >= j; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
