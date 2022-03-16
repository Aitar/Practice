from typing import List

"""
https://leetcode-cn.com/problems/valid-triangle-number/
"""


def triangleNumber(nums: List[int]) -> int:
    n = len(nums)
    if n < 3:
        return 0
    nums.sort()
    ans = 0

    for i in range(n - 2):
        l, r = i + 1, n - 1
        while r > l:
            while l < r and nums[i] + nums[l] <= nums[r]:
                l += 1
            ans += (r - l)
            r -= 1
    return ans

nums = [2,2,3,5, 8, 10, 11, 21, 40]
print(triangleNumber(nums))