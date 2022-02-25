from typing import List


def findRepeatedDnaSequences(s: str) -> List[str]:
    if len(s) < 10:
        return []

    ans = []
    dict = {}
    for i in range(9, len(s)):
        sub_str = s[i - 9: i + 1]
        if sub_str in dict and dict[sub_str] == 0:
            ans.append(sub_str)
            dict[sub_str] += 1
            print(dict[sub_str])
        elif sub_str not in dict:
            dict[sub_str] = 0

    return ans