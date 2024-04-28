package leetcode_buggy_version.java_bugg;

import java.util.Arrays;

public class Median_of_two_sorted_array {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int k = 0;
    int[] angram = new int[nums1.length + nums2.length];

    for (int i = 0; i < nums1.length; i++) {
      angram[k++] = nums1[i];
    }
    for (int i = 0; i < nums2.length; i++) {
      angram[k++] = nums2[i];
    }
    Arrays.sort(angram);
    int total = angram.length / 2;
    if (total % 2 == 1)
      return (double) angram[total / 2];
    else {
      int med1 = angram[total / 2 - 1];
      int med2 = angram[total / 2];
      return ((double) med1 + med2) / 2.0;
    }
  }
}

// https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/5045179/java-learn-day-45/
// Error: int total = angram.length / 2;