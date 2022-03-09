from typing import List


def fourSum(nums: List[int], target: int) -> List[List[int]]:
    ans = []
    n = len(nums)
    nums.sort()
    if n < 4:
        return ans

    for i in range(n - 3):
        if i != 0 and nums[i] == nums[i - 1]:
            continue
        if sum(nums[i:i + 4]) > target:
            # 如果i后4个数之和大于target，则不存在更多解了
            break
        # 如果nums[i]和最大的三个数之和小于target，则当前i不存在更多解
        if nums[i] + sum(nums[n - 3:]) < target:
            continue

        for j in range(i + 1, n - 2):
            if j != i + 1 and nums[j] == nums[j - 1]:
                continue
            if nums[i] + sum(nums[j:j + 3]) > target:
                break
            if nums[i] + nums[j] + sum(nums[n - 2:]) < target:
                continue
            l, r = j + 1, n - 1
            while l < r:
                s = nums[i] + nums[j] + nums[l] + nums[r]
                if s == target:
                    ans.append([nums[i], nums[j], nums[l], nums[r]])
                    while l < r and nums[r] == nums[r - 1]:
                        r -= 1
                    while l < r and nums[l] == nums[l + 1]:
                        l += 1
                    r -= 1
                    l += 1
                elif s > target:
                    r -= 1
                else:
                    l += 1

    return ans


nums = [2, 2, 2, 2, 2, 2]
target = 8
print(fourSum(nums, target))
