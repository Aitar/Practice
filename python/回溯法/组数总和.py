from typing import List

"""
https://leetcode-cn.com/problems/combination-sum/comments/
"""


def combinationSum(candidates: List[int], target: int) -> List[List[int]]:
    ans = []
    item = []
    sum = 0
    candidates.sort()
    dfs(candidates, sum, target, ans, item, 0)
    return ans


def dfs(candidates, sum, target, ans, item, idx):
    if sum == target:
        # 记录下当前组合
        temp = item[:]
        ans.append(temp)
        return

    start = 0 if idx == 0 else idx
    for i in range(start, len(candidates)):
        if sum + candidates[i] > target:
            break
        item.append(candidates[i])
        dfs(candidates, sum + candidates[i], target, ans, item, i)
        item.pop()


candidates = [2, 3, 6, 7]
target = 7
ans = combinationSum(candidates, target)
print()
