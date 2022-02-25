"""
https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
"""


def lengthOfLongestSubstring(s: str) -> int:
    n = len(s)
    if n <= 1:
        return n
    dict = {}
    l = r = ans = 0

    while r < len(s):
        if dict.get(s[r]) is not None and dict.get(s[r]) >= l:
            l = dict.get(s[r]) + 1
        ans = max(ans, r - l + 1)
        dict[s[r]] = r
        r += 1

    return ans
