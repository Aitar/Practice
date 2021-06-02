package Solution.DynamicPlan.划分型;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://www.lintcode.com/problem/437/
 */
public class 抄书 {
    public int copyBooks(int[] pages, int k) {
        if(pages == null || pages.length == 0) return 0;
        if(pages.length <= k) return Arrays.stream(pages).max().getAsInt();
        int[][] dp = new int[k + 1][pages.length + 1];
        int temp = 0;
        for(int i = 0; i < pages.length; i++) {
            temp += pages[i];
            dp[1][i + 1] = temp;
        }

        for(int i = 2; i <= k; i++) {
            for(int j = 1; j <= pages.length; j++) {
                if(i >= j) {
                    //如果抄书的人的数量 >= 书本数
                    dp[i][j] = Integer.MIN_VALUE;
                    for(int r = 0; r < j; r++)
                        dp[i][j] = Math.max(pages[r], dp[i][j]);
                } else {
                    //如果抄书的人的数量 < 书本数
                    int last = 0;
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int r = 1; j - r + 1 >= i; r++) {
                        last += pages[j - r];
                        dp[i][j] = Math.min(dp[i][j], Math.max(last, dp[i - 1][j - r]));
                    }
                }
            }
        }

        return dp[k][pages.length];
    }

    @Test
    public void test() {
        int[] pages = {3, 2, 5, 5, 6, 2, 3, 8, 3};
        int k = 3;
        System.out.println(copyBooks(pages, k));
    }
}
