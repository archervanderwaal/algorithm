class Solution:
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        if not nums:
            return False
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = (low + high) >> 1
            if target == nums[mid]:
                return True
            if nums[low] < nums[mid]:
                if target >= nums[low] and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            elif nums[low] > nums[mid]:
                if target > nums[mid] and target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
            else:
                low += 1
        return False