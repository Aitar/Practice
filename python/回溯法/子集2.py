from typing import List


def subsetsWithDup(nums: List[int]) -> List[List[int]]:
    ans = []
    idx = 0
    item = []
    is_visit = [False] * len(nums)
    dfs(nums, idx, item, ans, is_visit)
    return ans


def dfs(nums, idx, item, ans, is_visit):
    ans.append(item[:])
    for i in range(idx, len(nums)):
        if i > 0 and (not is_visit[i - 1]) and nums[i - 1] == nums[i]:
            continue
        item.append(nums[i])
        is_visit[i] = True
        dfs(nums, i + 1, item, ans, is_visit)
        item.pop()
        is_visit[i] = False


nums = [1, 2, 2]
ans = subsetsWithDup(nums)
print(ans)