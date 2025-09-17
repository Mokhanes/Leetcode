from typing import List

class Solution:
    def divideArray(self, nums: List[int], k: int) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        res = []
        
        # check in groups of 3 directly
        for i in range(0, n, 3):
            if nums[i+2] - nums[i] > k:
                return []
            res.append(nums[i:i+3])
        
        return res
