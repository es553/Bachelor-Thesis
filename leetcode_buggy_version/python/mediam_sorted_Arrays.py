import numpy as np # type: ignore

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        count_1 = 0
        count_2 = 0
        totEle = len(nums1)+len(nums2)
        arr = np.zeros(totEle//2+1)
        nums1.append(np.inf)
        nums2.append(np.inf)
        for idx in range(totEle//2+1):
            if nums1[count_1]>=nums2[count_2]:
                arr[idx]= nums1[count_1]
                count_1 = count_1+1
            elif nums1[count_1]>nums2[count_2]:
                arr[idx]= nums2[count_2]
                count_2 = count_2+1
        print(arr)
        if totEle %2 == 1:
            #odd
            return arr[-1]
        else:
            return (arr[-1]+arr[-2])/2

        
#https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/5068519/naive-implementation/
