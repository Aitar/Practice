
def minCut(s):
    """
    将一个字符串分割为多个回文串，使得分割次数最少
    划分型DP问题，重复枚举最后一段找到结果
    https://leetcode-cn.com/problems/palindrome-partitioning-ii/
    LS：将字符串 s 前 i 个字符划分为回文串最少的划分次数为 x
        那么设最后一段长度为 k ，那么前 i-k 个字符划分为回文串最少次数为 x-1
        子问题出现了
    SQ：将字符串前
    MF：令 f(i) 为前 i 个字符划分为回文串的最少划分次数，b(i, j) 为判断以 i 起始 j 结尾的字符串是否为回文串
        f(i) = min{ f(i - k) } + 1, when b(i, j)
           1 <= k <= i - 1
    B：f(0) = 0
    :type s: str
    :rtype: int
    """
    is_pali = [[False for _ in range(len(s))] for _ in range(len(s))]
    

