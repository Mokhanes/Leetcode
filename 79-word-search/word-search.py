class Solution:
    def exist(self, board, word):
        rows, cols = len(board), len(board[0])

        def dfs(r, c, idx):
            # If all characters matched
            if idx == len(word):
                return True
            # Out of bounds or mismatch
            if r < 0 or c < 0 or r >= rows or c >= cols or board[r][c] != word[idx]:
                return False

            # Mark as visited
            temp = board[r][c]
            board[r][c] = "#"

            # Explore 4 directions
            found = (dfs(r+1, c, idx+1) or
                     dfs(r-1, c, idx+1) or
                     dfs(r, c+1, idx+1) or
                     dfs(r, c-1, idx+1))

            # Restore the cell (backtrack)
            board[r][c] = temp
            return found

        # Try starting DFS from each cell
        for i in range(rows):
            for j in range(cols):
                if dfs(i, j, 0):
                    return True
        return False
