package leetcode_buggy_version.java_bugg;

// https://leetcode.com/problems/candy/solutions/5044051/simple-solution-beating-99-99-users-of-java/
public class Candy {
  public int candy(int[] ratings) {
    int length = ratings.length;
    int[] nums = new int[length];

    for (int i = 1; i < length; i++) {
      if (ratings[i - 1] < ratings[i]) {
        nums[i] = nums[i - 1] + 1;
      }
    }
    for (int i = length - 2; i >= 0; i--) {
      if (ratings[i + 1] < ratings[i]) {
        if (i == 0) {
          nums[i] = nums[i + 1] + 1;
          continue;
        }
        nums[i] = Math.max(nums[i], nums[i + 1] + 1);
      }
    }
    int result = length;
    for (int i = 0; i < length; i++) {
      result += nums[i];
    }
    return result;
  }
}
