from operator import itemgetter


def maxEnvelopes(envelopes):
    """
    二维的最长上升子序列问题，只需要按照(第一维，第二维)进行排序，然后再求第二维的最长上升子序列即可
    :type envelopes: List[List[int]]
    :rtype: int
    """
    envelopes.sort(key=itemgetter(0, 1))
    dp = [0] * (len(envelopes) + 1)
    ans = 0
    for i in range(1, len(dp)):
        for j in range(i - 1, 0, -1):
            if dp[i] < dp[j] and envelopes[i - 1][1] > envelopes[j - 1][1]:
                dp[i] = dp[j]

        dp[i] += 1
        ans = max(dp[i], ans)
    return ans


if __name__ == '__main__':
    e = [[5, 4], [6, 4], [6, 7], [2, 3]]
    maxEnvelopes(e)
