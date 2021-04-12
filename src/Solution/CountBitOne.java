package Solution;

/**
 * 计算bit为1的位数
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class CountBitOne {
    int[] pows = new int[31];

    public CountBitOne() {
        pows[0] = 1;
        for (int i = 1; i < 31; i++)
            pows[i] = pows[i - 1] * 2;
    }

    public int hammingWeight(int n) {
        int ans = 0;
        if (n < 0) {
            ans++;
            n = Integer.MAX_VALUE + n + 1;
        }
        for (int i = 30; i >= 0; i--) {
            if (n >= pows[i]) {
                n -= pows[i];
                ans++;
            }
        }
        return ans;
    }

    public int hammingWeight2(int n) {
        int res = 0;
        int a = 32;
        while (a != 0) {
            res += n & 1;
            n = n >> 1;
            a--;
        }
        return res;
    }
}
