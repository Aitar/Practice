package Solution.DynamicPlan.划分型;

import org.junit.Test;

/**
 * 给定一串数字，求其解码成不同字母串的方法数
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class 解码方法 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for(int i = 1; i <= s.length(); i++) {
            if(s.charAt(i - 1) != '0') dp[i] += dp[i - 1];
            if(i >= 2 && s.charAt(i - 2) != '0' && Integer.parseInt(s.substring(i - 2, i)) <= 26) dp[i] += dp[i - 2];
        }

        return dp[s.length()];
    }

    @Test
    public void test() {
        String str = "321513245";
        System.out.println(numDecodings(str));
    }
}
