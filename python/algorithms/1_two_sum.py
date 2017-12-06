class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        map = {}

        for index, value in enumerate(nums):
            if (target - value) in map:
                return [index, map[target - value]]
            map[value] = index

        return [-1, -1]

if __name__ == '__main__':
    data = Solution().twoSum([6, 2, 1], 7)
    print(data)