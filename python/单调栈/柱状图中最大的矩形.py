from typing import List


def largestRectangleArea(heights: List[int]) -> int:
    if max(heights) == min(heights):
        return max(heights) * len(heights)
    heights.append(0)
    s = []
    ans = [0] * len(heights)
    for i in range(len(heights)):
        for j in range(len(s) - 1, -1, -1):
            if heights[s[j]] > heights[i]:
                ans[j] = heights[s[j]] * (i - s[j])
                heights[s[j]] = heights[i]
            else:
                break
        s.append(i)
    return max(ans)


def largestRectangleArea2(heights: List[int]) -> int:
    if max(heights) == min(heights):
        return max(heights) * len(heights)

    heights = [0] + heights + [0]
    n = len(heights)
    res = [0] * n
    stack = [0]

    for i in range(1, n):
        while heights[i] < heights[stack[-1]]:
            pos = stack.pop()
            res[pos] = heights[pos] * (i - stack[-1] - 1)
        stack.append(i)

    return max(res)


heights = [2,1,2]
print(largestRectangleArea2(heights))
