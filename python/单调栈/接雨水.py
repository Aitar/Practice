"""
https://leetcode-cn.com/problems/trapping-rain-water/
"""
from typing import List


def trap(height: List[int]) -> int:
    s = []
    ans = 0
    u = 0
    for i in range(len(height)):
        while len(s) != 0 and height[i] > height[s[-1]]:
            u = height[s.pop()]
            if len(s) != 0:
                w = i - s[-1] - 1
                h = min(height[i], height[s[-1]]) - u
                a = w * h
                ans += a

        s.append(i)
    return ans

height = [0,1,0,2,1,0,1,3,2,1,2,1]
print(trap(height))
