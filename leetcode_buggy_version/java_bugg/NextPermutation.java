package leetcode_buggy_version.java_bugg;

import java.util.Arrays;

//https://leetcode.com/problems/next-permutation/solutions/5045809/easy-swap-and-reverse-finding-next-greater-number-beats-100-java 
public class NextPermutation {
  public void nextPermutation(int[] nums) {
    int n = nums.length;
    int sp = -1;
    int index = 0;
    // Find the number
    for (int i = n - 1; i > 0; i--) {
      if (nums[i - 1] < nums[i]) {
        sp = i - 1;
        break;
      }
    }
    // sort if in descending order
    if (sp == -1) {
      Arrays.sort(nums);
      return;
    }
    // Look for just greater number
    int start = sp + 1;
    for (int i = start; i < n; i++) {
      if (nums[i] > nums[sp] && nums[i] <= nums[start]) {
        index = i;
      }
    }
    // swap with just greater number
    swap(nums, sp, index);
    // reverse the part till last
    int ep = n - 1;
    while (ep > start) {
      swap(nums, ep, start);
      ep--;
      start++;
    }

  }

  public void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }
}
