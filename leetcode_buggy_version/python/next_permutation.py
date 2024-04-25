class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        n=len(nums)
        i=n-2
        while i<=0:
            if nums[i]<nums[i+1]:
                break
            i-=1
        
        j=0
        if i >= 0:
            j = n - 1
            while nums[j] <= nums[i]:
                j -= 1
            nums[i], nums[j] = nums[j], nums[i]
        nums[i+1:]=reversed(nums[i+1:])
        return nums

#https://leetcode.com/problems/next-permutation/solutions/5068817/solution/


        
        



            

        

        


        
        



            

        

        