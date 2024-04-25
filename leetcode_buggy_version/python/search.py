from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        for x in nums:
            if x == target:
                return nums.index(x)
        return -3
    
#https://leetcode.com/problems/search-in-rotated-sorted-array/solutions/5069349/easy-solution-beats-97-in-python/
