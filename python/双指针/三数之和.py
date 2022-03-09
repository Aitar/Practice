"""
https://leetcode-cn.com/problems/3sum/
"""
from typing import List


def threeSum(nums: List[int]) -> List[List[int]]:
    ans = []
    if len(nums) < 3 or min(nums) > 0:
        return ans
    nums.sort()

    n = len(nums)
    for i in range(0, n - 1):
        l, r = i + 1, n - 1
        if i != 0 and nums[i] == nums[i - 1]:
            continue
        while l < r:
            if nums[i] > 0:
                return ans
            s = nums[l] + nums[i] + nums[r]
            if s == 0:
                ans.append([nums[i], nums[l], nums[r]])
                while l < r and nums[r] == nums[r - 1]:
                    r -= 1
                while l < r and nums[l] == nums[l + 1]:
                    l += 1
                r -= 1
                l += 1
            elif s > 0:
                r -= 1
            else:
                l += 1

    return ans

nums = [-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0]
print(threeSum(nums))