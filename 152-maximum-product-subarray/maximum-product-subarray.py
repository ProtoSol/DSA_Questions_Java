class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        res = max(nums)
        currMin, currMax = 1, 1

        for n in nums:
            if n == 0:
                currMin, currMax = 1, 1
                continue
            temp = n * currMax
            currMax = max(n * currMax, n * currMin, n)
            currMin = min(temp, n * currMin, n)
            res = max(res, currMax, currMin)
        
        return res
        