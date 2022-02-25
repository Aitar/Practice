from typing import List


def subsets(nums: List[int]) -> List[List[int]]:
    ans = []
    idx = 0
    item = []
    dfs(nums, idx, item, ans)
    return ans


def dfs(nums, idx, item, ans):
    ans.append(item[:])
    for i in range(idx, len(nums)):
        item.append(nums[i])
        dfs(nums, i + 1, item, ans)
        item.pop()

nums = [1, 2, 3]
ans = subsets(nums)
print(ans)