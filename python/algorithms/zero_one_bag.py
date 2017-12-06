class Solution:
    def __init__(self):
        pass

    def search(self, idx, w, v, n, s, W, memo):

        # 如果已经搜索完了所有的物品
        if idx >= n:
            return 0

        # 如果装不下这件物品，直接返回不拿这件物品的重量即可
        if memo[idx][s] != -1:
            return memo[idx][s]
        if s + w[idx] > W:
            memo[idx][s] = self.search(idx + 1, w, v, n, s, W, memo)
            return memo[idx][s]

            # 否则我们直接返回拿idx这件物品和不拿这件物品的最大价值就行了!
        memo[idx][s] = max(self.search(idx + 1, w, v, n, s, W, memo),
                self.search(idx + 1, w, v, n, s + w[idx], W, memo) + v[idx])
        return memo[idx][s]

    def solve(self, w, v, W):
        n = len(w)
        memo = [[-1 for i in range(W + 1)] for j in range(n)]
        return self.search(0, w, v, n, 0, W, memo)


if __name__ == '__main__':
    w = [4, 3, 2, 5, 1]
    v = [3, 4, 1, 4, 2]

    print(Solution().solve(w, v, 10))
