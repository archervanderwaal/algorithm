class Solution:
    def searchRange(self, nums, target):
        """
         58 ms  beat 100%
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        index = self.binary_search(0, len(nums) - 1, nums, target)
        if index == -1:
            return [-1, -1]

        start, end = index, index
        while end <= len(nums) - 1:
            if nums[end] == target:
                end += 1
            else:
                break
        while start >= 0:
            if nums[start] == target:
                start -= 1
            else:
                break

        return [start + 1, end - 1]

    def binary_search(self, low, high, nums, target):
        while low <= high:
            mid = (low + high) >> 1
            if target < nums[mid]:
                high = mid - 1
            elif target > nums[mid]:
                low = mid + 1
            else:
                return mid
        return -1

if __name__ == '__main__':
    print(Solution().searchRange([1], 1))