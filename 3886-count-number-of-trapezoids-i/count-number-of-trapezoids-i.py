from collections import defaultdict
from typing import List
from math import comb

class Solution:
    def countTrapezoids(self, points: List[List[int]]) -> int:
        MOD = 10**9 + 7
        y_groups = defaultdict(list)

        # Group by y-coordinate
        for x, y in points:
            y_groups[y].append(x)

        # For each y, compute how many horizontal segments can be formed
        counts = []
        for y in y_groups:
            n = len(y_groups[y])
            if n >= 2:
                counts.append(comb(n, 2))

        # Optimized trapezoid count using mathematical identity
        total = sum(counts)
        square_sum = sum(c * c for c in counts)
        result = (total * total - square_sum) // 2
        return result % MOD