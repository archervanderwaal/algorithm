class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or not matrix[0]:
            return False
        m, n = len(matrix), len(matrix[0])
        low, high = 0, m - 1
        while low <= high:
            mid = (low + high) >> 1
            if target > matrix[mid][n - 1]:
                low = mid + 1
            elif target < matrix[mid][n - 1]:
                high = mid - 1
            else:
                return True
        if low >= m:
            return False

        row = low
        low, high = 0, n - 1
        while low <= high:
            mid = (low + high) >> 1
            if target > matrix[row][mid]:
                low = mid + 1
            elif target < matrix[row][mid]:
                high = mid - 1
            else:
                return True
        return False