
from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        indexing = dict()
        array = [[]]
        
            
        for i in range(len(nums)):
            if target-nums[i] in indexing:
                array.append(i)
                array.append(indexing[target-nums[i]])
                return array 
            indexing[nums[i]] = i


#https://leetcode.com/problems/two-sum/solutions/5068957/two-approach-python3/