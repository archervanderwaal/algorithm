class Solution:
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = (low + high) >> 1
            if target > nums[mid]:
                low = mid + 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                return mid

        return low