package leetcode_buggy_version.java_bugg;

public class RemoveDuplicatesFromSortedArray {

  public int removeDuplicates(int[] nums) {
    int j = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[j] = nums[i];
        i++;
      }
    }
    return j;
  }
}

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/solutions/5046192/array-remove-duplicates-easy-question/
// Error: i++;
