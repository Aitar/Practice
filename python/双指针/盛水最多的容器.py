from typing import List

"""
https://leetcode-cn.com/problems/container-with-most-water/
"""

def maxArea(height: List[int]) -> int:
    n = len(height)
    l, r, ans = 0, n - 1, 0

    while l < r:
        w = r - l
        h: int
        if height[l] <= height[r]:
            h = height[l]
            l += 1
        else:
            h = height[r]
            r -= 1

        ans = max(h * w, ans)

    return ans

nums = [1,4,6,2,5,4,8,3,7,1,5, 1,4, 5]
print(maxArea(nums))
