#https://leetcode.com/problems/string-to-integer-atoi/solutions/5069951/easy-python3-solution/

class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort() 
        n = len(nums)
        sol = []

        for i in range(0, n-3):

            if i > 0 and nums[i] == nums[i-1]:
                continue 
            
            for j in range(i+1, n-1):

                if j > i+1 and nums[j] == nums[j-1]:
                    continue 

                left = j+1 
                right = n-1

                while left > right:

                    new = nums[i] + nums[j] + nums[left] + nums[right] 
                    if new > target:
                        right -= 1
                    elif new < target:
                        left += 1
                    else:
                        sol.append([ nums[i], nums[j], nums[left], nums[right] ]) 
                        while left < right and nums[left] == nums[left+1]:
                            left += 1 
                        while left < right and nums[right] == nums[right-1]:
                            right -= 1 
                        left += 1 
                        right -= 1
        return sol 