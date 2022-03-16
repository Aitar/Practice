"""
https://leetcode-cn.com/problems/longest-repeating-character-replacement/
"""
from typing import Dict

"""
向右扩展窗口直到不能扩展为止(k < 0)
这时整体将窗口右移
"""
def characterReplacement1(s: str, k: int) -> int:
    n = len(s)
    if n == 1 or k >= n - 1:
        return n

    l, r, ans, maxCnt = 0, 0, 0, 0
    counts = [0] * 26
    counts[ord(s[r]) - ord('A')] += 1
    ik = k

    while r < n and n - l > ans:
        # 窗口右边扩张
        while k >= 0 and r < n:
            r += 1
            if r >= n:
                break
            counts[ord(s[r]) - ord('A')] += 1
            maxCnt = max(maxCnt, counts[ord(s[r]) - ord('A')])
            k = ik - (r - l + 1 - maxCnt)

        ans = max(ans, r - l)
        # 窗口整体向右滑动1格
        counts[ord(s[l]) - ord('A')] -= 1
        l += 1
        r += 1
        if r >= n:
            break
        counts[ord(s[r]) - ord('A')] += 1
        maxCnt = max(maxCnt, counts[ord(s[r]) - ord('A')])
        k = ik - (r - l + 1 - maxCnt)

    return ans

"""
但是实际上，上述过程可以合并
"""
def characterReplacement(s: str, k: int) -> int:
    n = len(s)
    if n == 1 or k >= n - 1:
        return n
    l, maxCnt = 0, 0
    counts = [0] * 26

    for r in range(n):
        counts[ord(s[r]) - ord('A')] += 1
        maxCnt = max(maxCnt, counts[ord(s[r]) - ord('A')])
        if r - l + 1 - maxCnt > k:
            counts[ord(s[l]) - ord('A')] -= 1
            l += 1

    return r - l + 1



s = "AABABBA"
k = 1
print(characterReplacement1(s, k))