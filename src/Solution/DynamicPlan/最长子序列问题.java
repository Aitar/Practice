package Solution.DynamicPlan;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://www.lintcode.com/problem/76/description      最长上升子序列
 *
 */

public class 最长子序列问题 {
    public int longestIncreasingSubsequence(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int ans = -1;
        Arrays.fill(dp, 1);
        for(int i = 1; i < nums.length; i++) {
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j] && max < dp[j])
                    max = dp[j];
            }
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    @Test
    public void testLIS() {
        int[] arr = {9,3,6,2,7};
        System.out.println(longestIncreasingSubsequence(arr));
    }
}
