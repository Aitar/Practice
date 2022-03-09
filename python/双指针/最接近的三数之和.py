from typing import List
import sys


def threeSumClosest(nums: List[int], target: int) -> int:
    min = sys.maxsize
    ans = target
    nums.sort()
    n = len(nums)
    for i in range(1, n - 1):
        l, r = 0, n - 1
        while l < i < r:
            s = nums[l] + nums[i] + nums[r]
            d = abs(s - target)
            if s == target:
                return target
            if d < min:
                min = d
                ans = s
            if s > target:
                r -= 1
            else:
                l += 1

    return ans

nums = [0,0,0]
target = 1
print(threeSumClosest(nums, target))