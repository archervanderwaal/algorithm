class Solution:
    def __init__(self):
        self._corr = [[-1, 0], [1, 0], [0, -1], [0, 1]]

    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if not board or not board[0] or not word or len(board) * len(board[0]) < len(word):
            return False
        marked = [[False for i in range(len(board[0]))] for j in range(len(board))]

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    marked[i][j] = True
                    if self.dfs(board, marked, word, 1, i, j):
                        return True
                    marked[i][j] = False

        return False

    def dfs(self, board, marked, word, si, x, y):
        if si == len(word):
            return True
        for i in range(4):
            nx, ny = x + self._corr[i][0], y + self._corr[i][1]
            if nx < 0 or nx > len(board) - 1 or ny < 0 or ny > len(board[0]) - 1 or marked[nx][ny] or board[nx][ny] != word[si]:
                continue
            marked[nx][ny] = True
            if self.dfs(board, marked, word, si + 1, nx, ny):
                return True
            marked[nx][ny] = False
        return False

if __name__ == '__main__':
    board = [
    ['A','B','C','E'],
    ['S','F','C','S'],
    ['A','D','E','E']
    ]
    print(Solution().exist(board, 'ABC'))