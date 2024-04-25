class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        ## Solution 1
        # seen = set()
        # unique_vals = []
        # for num in nums:
        #     if num not in unique_vals:
        #         seen.add(num)
        #         unique_vals.append(num)
        
        # nums[:len(unique_vals)] =  unique_vals
        # return len(unique_vals)


        ## Solution 2:
        if len(nums) == 0:
            return 0

        curr_index = 1
        for i in range(len(nums)):
            if nums[i] != nums[curr_index]:
                curr_index = curr_index +1
                nums[curr_index] = nums[i]
        
        return curr_index +1
    
#https://leetcode.com/problems/remove-duplicates-from-sorted-array/solutions/5043757/removing-duplicates-from-sorted-arrays/
        