class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        if len(nums) < 3:
            return len(nums)
        slow = 2
        for fast in range(2, len(nums)):
            if nums[fast] != nums[slow - 2]:
                nums[slow] = nums[fast]
                slow += 1
        return slow

if __name__ == '__main__':
    nums = [1, 1, 1, 2, 2, 3]
    size = Solution().removeDuplicates(nums)
    for i in range(size):
        print(nums[i])