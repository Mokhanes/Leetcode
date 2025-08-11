class Solution:
    def wordBreak(self, s: str, wordDict: list[str]) -> bool:
        word_set = set(wordDict)  # O(1) lookup
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True  # base case

        for i in range(1, n + 1):
            for j in range(i):
                if dp[j] and s[j:i] in word_set:
                    dp[i] = True
                    break  # no need to check more splits

        return dp[n]
