"""
https://leetcode-cn.com/problems/max-consecutive-ones/
"""
from typing import List


def findMaxConsecutiveOnes(nums: List[int]) -> int:
    n = len(nums)
    ans = 0
    l = -1
    for r in range(n + 1):
        if r == n or nums[r] == 0:
            ans = max(r - l - 1, ans)
            l = r

    return ans

nums = [1,1,0,1,1,1,1]
print(findMaxConsecutiveOnes(nums))