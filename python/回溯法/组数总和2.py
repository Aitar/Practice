from typing import List, Dict


def combinationSum2(candidates: List[int], target: int) -> List[List[int]]:
    t = sum(candidates)
    if t < target:
        return []
    ans = []
    item = []
    is_repeat = [False] * len(candidates)
    s = 0
    dict: Dict = {}
    candidates.sort()
    dfs(candidates, target, ans, item, s, t, dict, -1)
    return ans


def dfs(candidates, target, ans, item, sum, t, dict, idx):
    # 退出条件
    if t < target:
        return

    if sum == target:
        temp = item[:]
        key = str(temp)
        if dict.get(key) is None:
            dict[key] = temp
            ans.append(temp)
        return

    for i in range(idx + 1, len(candidates)):
        if sum + candidates[i] > target:
            break
        item.append(candidates[i])
        dfs(candidates, target, ans, item, sum + candidates[i], t, dict, i)
        item.pop()
        if len(item) == 0:
            t -= candidates[i]



c = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
t = 30
a = combinationSum2(c, t)
print()