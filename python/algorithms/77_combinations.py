class Solution:
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        ans = []
        if n < 1 or k < 1:
            return ans
        self.dfs(1, n, k, ans, [])
        return ans

    def dfs(self, start, n, k, ans, tmp):
        if k == 0:
            # 复制方法tmp[:], list(tmp), copy.copy(tmp)
            ans.append(list(tmp))
            return

        for i in range(start, n + 1):
            tmp.append(i)
            self.dfs(i + 1, n, k - 1, ans, tmp)
            del tmp[-1]

if __name__ == '__main__':
    print(Solution().combine(4, 2))