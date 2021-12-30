package Solution.DynamicPlan.序列型;

import org.junit.Test;

import java.util.Arrays;

/**
 * 这类问题通常是求一串数字中满足某种简单关系的序列
 * 进阶到“股票问题”和“背包问题”就是满足特殊关系的序列
 *      股票问题：单向状态转移，空仓1 -> 持有1 -> 空仓2 -> 持有2...
 *      背包问题：满足序列和小于或等于某值，并且价值最大等等关系
 */
public class 最长子序列问题 {
    /**
     * 2021.12.17
     * 最长上升子序列问题
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/submissions/
     * LS：前n个序列最长上升子序列长度为x
     *     那么前 n-1 序列的最长上升序列为多少？
     * SQ：若最后一个元素加入的最长上升子序列，则前n-1个的最长上升子序列长为x-1
     *      若未加入，则长为x
     *      子问题出现了！
     * MF：令f(i)为前 i 个序列的最长上升子序列长度，则有：
     *      f(i) = max{f(j)} + 1
     *       0 <= j < i-1 and a[i - 1] > a[j]
     * B：f(0) = 0
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int max = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (dp[i] < dp[j] && nums[i - 1] > nums[j - 1])
                    dp[i] = dp[j];
            }
            dp[i]++;
            max = Math.max(dp[i], max);
        }
        return max;
    }

    @Test
    public void testLIS() {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
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

    /**
     * 堆箱子，三维的最长上升子序列问题
     * https://leetcode-cn.com/problems/pile-box-lcci/
     * 是一个二维数组，第二维有{w, d ,h}，下面的箱子长宽高都必须大于上面的箱子，且箱子不能翻转
     * 求能堆出的最高的箱子的高度
     * 只需要求出满足 w1 > w2 && d1 > d2 && h1 > h2 的最长上升子序列即可
     */
    public int pileBox(int[][] box) {
        if(box == null || box.length == 0)
            return 0;
        Arrays.sort(box, (a, b) -> {
            if(a[0] == b[0]) {
                if(a[1] == b[1])
                    return a[2] - b[2];
                else
                    return a[1] - b[1];
            } else return a[0] - b[0];
        });

        int[] dp = new int[box.length + 1];
        int ans = 0;

        for(int i = 1; i <= box.length; i++)
            dp[i] = box[i - 1][2];

        for(int i = 1; i <= box.length; i++) {
            int max = 0;
            for(int j = i - 1; j > 0; j--) {
                if(box[i - 1][0] > box[j - 1][0] && box[i - 1][1] > box[j - 1][1] && box[i - 1][2] > box[j - 1][2] && max < dp[j])
                    max = dp[j];
            }
            dp[i] += max;
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
    
    @Test
    public void test() {
        int[][] box = {{1, 1, 1}, {2, 3, 4}, {2, 6, 7}, {3, 4, 5}};
        System.out.println(pileBox(box));
    }
}
