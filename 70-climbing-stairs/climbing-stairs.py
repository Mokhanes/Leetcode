class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """

        if n <= 3:
            return n

        a = 3
        b = 2 

        for i in range(n-3):
            a = a+b
            b = a-b

        return a
        