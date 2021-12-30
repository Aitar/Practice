package Solution.DynamicPlan.序列型;

import org.junit.Test;

/**
 * https://www.lintcode.com/problem/backpack    背包问题
 * https://www.lintcode.com/problem/125         背包问题II
 * https://www.lintcode.com/problem/440         背包问题III
 * https://www.lintcode.com/problem/562         背包问题IV
 * https://www.lintcode.com/problem/563         背包问题V
 */
public class 背包问题 {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        int ans = 0;
        boolean[][] dp = new boolean[A.length + 1][m + 1];

        for(int i = 0; i <= A.length; i++) {
            for(int j = 0; j <= m; j++) {
                if(j == 0) dp[i][j] = true;
                else if(i == 0) dp[i][j] = false;
                else {
                    dp[i][j] = dp[i - 1][j];
                    if(j >= A[i - 1])
                        dp[i][j] = dp[i][j] || dp[i - 1][j - A[i - 1]];
                }
                if(dp[i][j])
                    ans = Math.max(ans, j);
            }
        }

        return ans;
    }


    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        int ans = 0;
        int[][] dp = new int[A.length + 1][m + 1];

        for(int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = j >= A[i - 1] ? Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1]) : dp[i - 1][j];
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return 0;
    }

    /**
     * @param A: an integer array
     * @param V: an integer array
     * @param m: An integer
     * @return: an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        int ans = 0;
        int[][] dp = new int[A.length + 1][m + 1];

        for(int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                for(int k = 0; k * A[i - 1] <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * A[i - 1]] + k * V[i - 1]);
                }
                if (i == A.length)
                    ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }

    @Test
    public void test3() {
        int[] A = {1,3,5,7};
        int[] V = {1,5,2,4};
        int m = 10;
        int i = backPackIII(A, V, m);
        System.out.println(i);
    }

    /**
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackIV(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target + 1];

        for(int i = 0; i <= nums.length; i++) {
            for(int j = 0; j <= target; j++) {
                if(j == 0) dp[i][j] = 1;
                else if(i == 0) dp[i][j] = 0;
                else {
                    for(int k = 0; k * nums[i - 1] <= j; k++) {
                        dp[i][j] += dp[i - 1][j -  k * nums[i - 1]];
                    }
                }
            }
        }

        return dp[nums.length][target];
    }

    /**
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int backPackV(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if(j == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j];
                    if(j >= nums[i - 1])
                        dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][target];
    }


}
