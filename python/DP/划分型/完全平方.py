import math, sys


def numSquares(n: int) -> int:
    """
    LS：正整数 a 最少由 n 个完全平方数的和组成
        设最后一个完全平方数是 b，那么 a-b 最少由 n-1 个完全平方数组成
        子问题出现了
    MF：f(i) := 正整数 i 最少组成的完全平方数量
        f(i) = min{ f(i - j^2) + 1 }
          1 <= j^2 <= i
    https://leetcode-cn.com/problems/perfect-squares/
    :param n:
    :return:
    """
    dp = [0 for _ in range(n + 1)]

    for i in range(1, n + 1):
        temp = sys.maxsize
        for j in range(0, int(pow(i, 0.5))):
            temp = min(temp, dp[i - pow(j + 1, 2)])
        dp[i] = temp + 1

    return dp[n]

if __name__ == '__main__':
    n = 10
    print(numSquares(n))
