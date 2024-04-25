package leetcode_buggy_version.java_bugg;

// https://docs.google.com/document/d/145YsjVQP981Su34Yr9W_5173IRn83LWUtCHiOAoFlsI/edit
public class Search_In_Rotated_Sort {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    if (nums[0] < nums[nums.length - 1]) {
      binSerach(left, right, nums, target);
    }
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (target < nums[0] && nums[mid] >= nums[0]) {
        left = mid + 1;
        continue;
      }
      if (target >= nums[0] && nums[mid] < nums[0]) {
        right = mid - 1;
        continue;
      }
      if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

  private int binSerach(int left, int right, int[] nums, int target) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
