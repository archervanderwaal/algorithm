class Solution:
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        if not heights:
            return 0
        ans, stack = 0, []
        heights.append(-1)
        for i in range(len(heights)):
            current = heights[i]
            if len(stack) == 0 or current >= heights[stack[-1]]:
                stack.append(i)
            else:
                while len(stack) != 0 and current < heights[stack[-1]]:
                    h = heights[stack.pop()]
                    left = stack[-1] if len(stack) != 0 else -1
                    ans = max(ans, h * (i - left - 1))
                stack.append(i)
        return ans