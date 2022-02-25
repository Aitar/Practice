from typing import List


def solveNQueens(n: int) -> List[List[str]]:
    res = []
    item = []
    dfs(n, res, item, 0)
    ans = [['' for _ in range(n)] for _ in range(len(res))]
    for i in range(len(res)):
        for j in range(n):
            ans[i][j] = '.' * res[i][j] + 'Q' + '.' * (n - res[i][j] - 1)
    return ans

def dfs(n, res, item, layer):
    if len(item) == n:
        res.append(item[:])
        return

    visiteble = [True] * n
    for i in range(len(item)):
        visiteble[item[i]] = False
        if item[i] + layer - i < n:
            visiteble[item[i] + layer - i] = False
        if item[i] - layer + i >= 0:
            visiteble[item[i] - layer + i] = False

    for i in range(0, n):
        if visiteble[i]:
            item.append(i)
            dfs(n, res, item, layer + 1)
            item.pop()

ans = solveNQueens(4)
print()