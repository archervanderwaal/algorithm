from collections import Counter


class Solution:
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        counter = Counter()

        for char in s:
            counter[char] = counter[char] + 1

        for char in t:
            counter[char] = counter[char] - 1
            if counter[char] < 0:
                return False

        for v in counter.elements():
            if counter[v] != 0:
                return False

        return True


if __name__ == '__main__':
    print(Solution().isAnagram('a', 'ab'))