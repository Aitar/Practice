package Solution.DynamicPlan.划分型;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 * 重复枚举最后一段，判断最后一段是不是回文串
 */
public class 分割回文串 {
    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];
        boolean[][] isPalindrome = getIsPalindrome(s);
        dp[0] = -1;
        for(int i = 2; i <= s.length(); i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 1; i - j >= 0; j++) {
                if(isPalindrome[i - j][i - 1] && min > dp[i - j]) {
                    min = dp[i - j];
                }
            }
            dp[i] = min + 1;
        }

        return dp[s.length()];
    }

    /**
     * 生成字符串所有回文子串的判断数组
     * @param str 字符串父串
     * @return 判断结果数组
     */
    private boolean[][] getIsPalindrome(String str) {
        boolean[][] isPalindrome = new boolean[str.length()][str.length()];

        for(int len = 1; len <= str.length(); len++) {
            for(int i = 0; i + len - 1 < str.length(); i++) {
                if(len == 1) isPalindrome[i][i] = true;
                else if(len == 2) isPalindrome[i][i + 1] = str.charAt(i) == str.charAt(i + 1);
                else {
                    int j = i + len - 1;
                    isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && str.charAt(i) == str.charAt(j);
                }
            }
        }

        return isPalindrome;
    }

    @Test
    public void test() {
        String str = "aabcc";
        System.out.println(minCut(str));
    }
}
