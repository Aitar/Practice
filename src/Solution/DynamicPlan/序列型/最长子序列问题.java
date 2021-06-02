package Solution.DynamicPlan.序列型;

import org.junit.Test;

import java.util.Arrays;

/**
 * 这类问题通常是求一串数字中满足某种简单关系的序列
 * 进阶到“股票问题”和“背包问题”就是满足特殊关系的序列
 *      股票问题：满足两两差值最大的子序列
 *      背包问题：满足序列和小于或等于某值，并且价值最大等等关系
 */
public class 最长子序列问题 {
    /**
     * 最长上升子序列问题
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/
     * 思路：求以第 i 个数字结尾的最长上升子序列是多少？
     *      找到前 i - 1 个数字中的结尾数字小于nums[i]且长度最大的数字即可
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int ans = 0;
        for(int i = 1; i < nums.length; i++) {
            int max = -1;
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j] && max < dp[j])
                    max = dp[j];
            }
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }

        return ans + 1;
    }

    @Test
    public void testLIS() {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(longestIncreasingSubsequence(arr));
    }


    /**
     * 俄罗斯套娃信封问题(二维最长上升子序列)
     * https://leetcode-cn.com/problems/russian-doll-envelopes/
     * 变成了二维的最长上升子序列，只需要先对（第一维，第二维）进行排序，再求第二维的最长上升子序列即可
     */
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0) return 0;
        int ans = 0;
        int[] dp = new int[envelopes.length];

        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });
        for(int i = 0; i < envelopes.length; i++) {
            int max = -1;
            for(int j = i - 1; j >= 0; j--) {
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0] && max < dp[j])
                    max = dp[j];
            }
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }

        return ans + 1;
    }

    @Test
    public void testMaxEnvelopes() {
        int[][] arr = {{5,4}, {6,4}, {6,7}, {2,3}};
        System.out.println(maxEnvelopes(arr));
    }


    /**
     * 摆动序列
     * https://leetcode-cn.com/problems/wiggle-subsequence/
     * 最长的摆动序列，不过是最长上升子序列的变种，每次加入只需要调整大小于号即可
     */
    public int wiggleMaxLength(int[] nums) {
        if(nums == null) return 0;
        if(nums.length <= 1) return nums.length;

        boolean[] up = new boolean[nums.length];
        int[] dp = new int[nums.length];
        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            int max = -1;
            for(int j = i - 1; j >= 0; j--) {
                if(dp[j] == 0 && max == -1 && nums[i] != nums[j]) {
                    up[i] = nums[i] > nums[j];
                    max = dp[j];
                } else if(((nums[i] > nums[j] && !up[j]) || (nums[i] < nums[j] && up[j])) && max < dp[j]) {
                    max = dp[j];
                    up[i] = nums[i] > nums[j];
                }
            }
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }

        return ans + 1;
    }

    @Test
    public void testWiggleMaxLength() {
        int[] nums = {3,3,3,2,5};
        System.out.println(wiggleMaxLength(nums));
    }
}
