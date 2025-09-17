class Solution:
    def divideArray(self, nums: List[int], k: int) -> List[List[int]]:
        nums.sort()
        res = []
        x = []
        j = 0
        mi = None
        for i in nums:
            if j==3:
                res.append(x)
                j=1
                x = [i]
                mi = i
            else:
                if mi == None:
                    mi = i
                else:
                    if i-mi>k:
                        return []
                x.append(i)
                j+=1
        res.append(x)
        return res
            