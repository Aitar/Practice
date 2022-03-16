"""
https://leetcode-cn.com/problems/arithmetic-slices/
"""
from typing import List


def numberOfArithmeticSlices(nums: List[int]) -> int:
    n = len(nums)
    if n < 3 or (n == 3 and nums[2] - nums[1] != nums[1] - nums[0]):
        return 0
    l = 0
    ans: int = 0
    while l + 2 < n:
        r = l + 2
        while r < n and nums[r] - nums[r - 1] == nums[r - 1] - nums[r - 2]:
            r += 1
        r -= 1
        ans += int((r - l - 1) * (r - l) / 2)
        l = r

    return ans

nums = [1,2,3,4,5,6]
print(numberOfArithmeticSlices(nums))