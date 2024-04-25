package leetcode_buggy_version.java_bugg;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/solutions/5046192/array-remove-duplicates-easy-question/
public class RemoveDuplicatesFromSortedArray {

  public int removeDuplicates(int[] nums) {
    int j = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[j] = nums[i];
        j++;
      }
    }
    return j;
  }
}
