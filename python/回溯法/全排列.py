from typing import List


def permute(nums: List[int]) -> List[List[int]]:
    ans = []
    is_visit = [False] * len(nums)
    item = []
    dfs(nums, item, ans, is_visit)
    return ans


def dfs(nums, item, ans, is_visit):
    if len(item) == len(nums):
        ans.append(item[:])
        return

    for i in range(len(nums)):
        item.append(nums[i])
        if not is_visit[i]:
            is_visit[i] = True
            dfs(nums, item, ans, is_visit)
            is_visit[i] = False
        item.pop()


nums = [1,2,3]
a = permute(nums)
print()