"""
背包问题，常见序列型问题，只需要把背包容量加入状态即可
"""


def backPack(m, A):
    """
        单次可行背包
        https://www.lintcode.com/problem/92/
        @param m: An integer m denotes the size of a backpack
        @param A: Given n items with size A[i]
        @return: The maximum size

        LS：前 n 个物品，背包能装的最大容量是 x
            那么前 n-1 个物品，背包最大能装多少容量？
            若第 n 个物品装入背包，那么前 n-1 个物品最多装入 x - w[n-1]
            若不装入，那么前 n-1 个物品最多装入 x
            子问题出现了！
        SQ：前 i 个物品能装否装到重量 j，取决于：A or B
            A = 前 i-1个物品能否装到重量 j
            B = 前 i-1个物品能否装到重量 j - w[i-1] (j >= w[i-1])
        MF：令f(i, j)为前 i-1 个物品能否装到重量 j
            f(i, j) = f(i-1, j)                         ,j < w[i-1]
            f(i, j) = f(i-1, j - w[i-1]) or f(i-1, j)   ,j >= w[i-1]
        B：i = 0 and j = 0 时，f(i, j) = T
           i = 0, f(i, j) = F
           j = 0, f(i, j) = T

    """
    # write your code here
    ans = 0
    dp = [[False for _ in range(m + 1)] for _ in range(len(A) + 1)]
    dp[0][0] = True

    for i in range(1, len(dp)):
        for j in range(0, len(dp[i])):
            dp[i][j] = dp[i - 1][j]
            if j >= A[i - 1]:
                dp[i][j] = dp[i][j] or dp[i - 1][j - A[i - 1]]
            if dp[i][j]:
                ans = max(j, ans)

    return ans


def backPackII(m, A, V):
    """
    https://www.lintcode.com/problem/125
    单次价值背包问题，只需要将原来的可行性背包存储的内容改为当前的最大价值即可
    令f(i, j)为前 i-1 个物品装到重量 j 的最大价值
        f(i, j) = f(i-1, j)                                             ,j < A[i-1]
        f(i, j) = max{ f(i-1, j - A[i-1]) + v[i - 1], f(i-1, j) }       ,j >= A[i-1]
    @param m: An integer m denotes the size of a backpack
    @param A: Given n items with size A[i]
    @param V: Given n items with value V[i]
    @return: The maximum value
    """
    # write your code here
    n = len(A)
    dp = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
    ans = 0

    for i in range(1, n + 1):
        for j in range(m + 1):
            if j < A[i - 1]:
                dp[i][j] = dp[i - 1][j]
            else:
                dp[i][j] = max(dp[i - 1][j - A[i - 1]] + V[i - 1], dp[i - 1][j])
            if i == n:
                ans = max(ans, dp[i][j])

    return ans


def backPackIII(A, V, m):
    """
    无限次背包的价值问题
    在单次价值背包的基础上加入 k := 第 i-1 个物品放入的个数
        f(i, j) = max{ f(i - 1, j - k * A[i-1]) + k * V[i - 1] }
              0 <= k <= j / A[i -1], k ∈ Z+
    :param A:
    :param V:
    :param m:
    :return:
    """
    n = len(A)
    dp = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
    ans = 0

    for i in range(1, n + 1):
        for j in range(m + 1):
            for k in range(int(j / A[i - 1]) + 1):
                dp[i][j] = max(dp[i][j], dp[i - 1][j - k * A[i - 1]] + k * V[i - 1])
            ans = max(ans, dp[i][j])

    return ans


def backPackIV(nums, target):
    """
    无限次背包的可行数量问题
    令f(i, j)为 i-1 个物品装到重量 j 的方案数
        f(i, j) = Σ f(i - 1, j - k * A[i-1])
            0 <= k <= j / A[i -1], k ∈ Z+
    @param nums: an integer array and all positive numbers, no duplicates
    @param target: An integer
    @return: An integer
    """
    n = len(nums)
    dp = [[0 for _ in range(target + 1)] for _ in range(n + 1)]
    dp[0][0] = 1

    for i in range(1, n + 1):
        for j in range(target + 1):
            for k in range(int(j / nums[i - 1]) + 1):
                dp[i][j] += dp[i - 1][j - k * nums[i - 1]]
    return dp[n][target]


def backPackV(nums, target):
    dp = [[0 for _ in range(target + 1)] for _ in range(2)]
    dp[0][0] = 1
    s = True

    for i in range(1, len(nums) + 1):
        for j in range(target + 1):
            if s:
                dp[1][j] = dp[0][j]
                if j >= nums[i - 1]:
                    dp[1][j] += dp[0][j - nums[i - 1]]
            else:
                dp[0][j] = dp[1][j]
                if j >= nums[i - 1]:
                    dp[0][j] += dp[1][j - nums[i - 1]]
        s = bool(1 - s)

    return max(dp[0][target], dp[1][target])


if __name__ == '__main__':
    a = [1,2,3,3,7]
    b = 5
    print(backPackV(a, b))
